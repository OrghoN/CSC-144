/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

import com.jgraph.layout.JGraphFacade;
import com.jgraph.layout.JGraphLayout;
import com.jgraph.layout.organic.JGraphOrganicLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
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
import org.jgrapht.ext.JGraphModelAdapter;
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

        List<String> links = new LinkedList<String>();
        while (m.find()) {
            String link = m.group().replace("\"", "").replace("*:", "");
            if (!(link.contains("Template") || link.contains("Category") || links.contains(link))) {
                links.add(link);
            }
        }

        return links;
    }

    public void init() {
        ListenableGraph<String, MyEdge> g = new ListenableDirectedGraph<String, MyEdge>(MyEdge.class);
        jgAdapter = new JGraphModelAdapter(g);
        JGraph jgraph = new JGraph(jgAdapter);
        ConnectionSet cs = new ConnectionSet();

        String article = "Java";

        List<String> links = parseLinks(article);

        g.addVertex(article);

        for (String link : links) {
            g.addVertex(link);
            g.addEdge(article, link);

        }
        jgraph.setAutoResizeGraph(true);

        JGraphLayout layout = new JGraphOrganicLayout(new Rectangle(-500, 0, 700, 700));
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
//        UnidrectedGraph<String, DefaultEdge> g
//        PrintWriter out = new PrintWriter("linkDump.JSON", "UTF-8");
//        out.println(links);
//        out.close();
    }

}
