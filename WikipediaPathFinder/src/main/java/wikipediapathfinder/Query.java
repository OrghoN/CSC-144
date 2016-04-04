/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.JGraphLayout;
import com.jgraph.layout.tree.JGraphTreeLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import net.sourceforge.jwbf.core.actions.ContentProcessableBuilder;
import net.sourceforge.jwbf.core.actions.Get;
import net.sourceforge.jwbf.core.actions.HttpActionClient;
import net.sourceforge.jwbf.core.actions.ResponseHandler;
import net.sourceforge.jwbf.mediawiki.ApiRequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jgraph.JGraph;
import org.jgraph.graph.ConnectionSet;
import org.jgrapht.ListenableGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author orgho
 */
public class Query extends JApplet {

    static HttpActionClient testee = HttpActionClient.builder()
            .withClient(HttpClientBuilder.create().build())
            .withUrl("https://www.wikipedia.org/w/")
            .build();

    static ListenableGraph g = new ListenableDirectedGraph(DefaultEdge.class);

    static final int RECURSION_LIMIT = 3;

    static final String goal = "Colorado College";
    static final String start = "Mount Vernon, Iowa";

    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(4000, 4000);

    @SuppressWarnings("rawtypes")
    private JGraphModelAdapter jgAdapter;

    @SuppressWarnings({"unchecked", "rawtypes"})

    public static String getLinks(String title) {
        title = title.replace(" ", "_");

        Get parse = new ApiRequestBuilder()
                .formatJson()
                .action("parse")
                .param("page", title)
                .param("prop", "links")
                .buildGet();

        ResponseHandler<String> getParse = ContentProcessableBuilder.create(testee).withActions(parse).build();

        return getParse.get().toString();
    }

    public static List<String> parseLinks(String title) {
        String linksString = getLinks(title);
        Pattern p = Pattern.compile("(\\*\":\".*?\")", Pattern.DOTALL);
        Matcher m = p.matcher(linksString);
        g.addVertex(title);

        List<String> links = new LinkedList<String>();
        while (m.find()) {
            String link = m.group().replace("\"", "").replace("*:", "");
            if (!(link.contains("Template") || link.contains("Category") || link.contains("\\u") || g.containsVertex(link))) {
                g.addVertex(link);
                g.addEdge(title, link);
                if (link.equals(goal)) {
                    List<String> found = new LinkedList<String>();
                    found.add("Found");
                    return found;
                }
                links.add(link);
            }
        }

        return links;
    }

    public static ListenableGraph<String, DefaultEdge> graphPath(List<DefaultEdge> path) {
        ListenableGraph pathGraph = new ListenableDirectedGraph(DefaultEdge.class);

        for (Object edge : path) {
            String edgeString = edge.toString();
            edgeString = edgeString.substring(1, edgeString.length() - 1);

            String[] vertices = edgeString.split(":");

            vertices[0] = vertices[0].trim();
            vertices[1] = vertices[1].trim();

            if (!pathGraph.containsVertex(vertices[0])) {
                pathGraph.addVertex(vertices[0]);
            }
            if (!pathGraph.containsVertex(vertices[1])) {
                pathGraph.addVertex(vertices[1]);
            }

            pathGraph.addEdge(vertices[0], vertices[1]);
        }
        return pathGraph;
    }

    public static void parseLinks(List<String> links, int counter) {
        List<String> found = new LinkedList<String>();
        found.add("Found");

        List<String> globalLinks = new LinkedList<String>();

        for (String link : links) {
            List<String> result = parseLinks(link);
            if (result.equals(found)) {
                return;
            } else {
                globalLinks.addAll(result);
            }

        }

        counter++;
        System.out.println(counter);

        if (counter < RECURSION_LIMIT) {
            parseLinks(globalLinks, counter);
        }

    }

    public void init() {
        List<String> found = new LinkedList<String>();
        found.add("Found");

        List<String> links = parseLinks(start);
        if (!links.equals(found)) {
            parseLinks(links, 1);
        }

        DijkstraShortestPath<String, DefaultEdge> pathFinder = new DijkstraShortestPath(g, start, goal);
        List<DefaultEdge> pathList = pathFinder.getPathEdgeList();
        ListenableGraph<String, DefaultEdge> pathGraph = graphPath(pathList);

        jgAdapter = new JGraphModelAdapter(pathGraph);
        JGraph jgraph = new JGraph(jgAdapter);
        ConnectionSet cs = new ConnectionSet();

        jgraph.setAutoResizeGraph(true);

        JGraphLayout layout = new JGraphTreeLayout();
//        JGraphLayout layout = new JGraphSelfOrganizingOrganicLayout();
        JGraphFacade facade = new JGraphFacade(jgraph);
        layout.run(facade);
        Map nested = facade.createNestedMap(false, false);

//        GraphConstants.setLabelEnabled(jgraph, false);
        jgraph.getGraphLayoutCache().edit(nested);
        jgraph.validate();

        JScrollPane sp = new JScrollPane(jgraph);
        getContentPane().add(sp);
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Query applet = new Query();
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraph Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.show();

//        PrintWriter out = new PrintWriter("linkDump.JSON", "UTF-8");
//        out.println(pathGraph);
//        out.close();
    }

}
