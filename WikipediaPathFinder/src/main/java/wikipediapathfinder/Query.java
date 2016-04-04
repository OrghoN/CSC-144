/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.jwbf.core.actions.ContentProcessableBuilder;
import net.sourceforge.jwbf.core.actions.Get;
import net.sourceforge.jwbf.core.actions.HttpActionClient;
import net.sourceforge.jwbf.core.actions.ResponseHandler;
import net.sourceforge.jwbf.mediawiki.ApiRequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jgrapht.ListenableGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author orgho
 */
public class Query {

    static HttpActionClient testee = HttpActionClient.builder()
            .withClient(HttpClientBuilder.create().build())
            .withUrl("https://www.wikipedia.org/w/")
            .build();

    static ListenableGraph g = new ListenableDirectedGraph(DefaultEdge.class);

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

    public static List<String> parseLinks(String title, String goal) {
        String linksString = getLinks(title);
        Pattern p = Pattern.compile("(\\*\":\".*?\")", Pattern.DOTALL);
        Matcher m = p.matcher(linksString);
        g.addVertex(title);

        List<String> links = new LinkedList<String>();
        while (m.find()) {
            String link = m.group().replace("\"", "").replace("*:", "");
            if (!(link.contains("Template") || link.contains("Category") || g.containsVertex(link))) {
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

    public static boolean parseLinks(List<String> links, String goal) {
        List<String> found = new LinkedList<String>();
        found.add("Found");

        List<String> globalLinks = new LinkedList<String>();

        for (String link : links) {
            List<String> result = parseLinks(link, goal);
            if (result.equals(found)) {
                return true;
            } else {
                globalLinks.addAll(result);
            }

        }

        System.out.println(globalLinks);
        parseLinks(globalLinks, goal);
//        System.out.println(globalLinks);

        return false;

    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String goal = "Achievement test";
        String start = "Mount Vernon, Iowa";
        List<String> links = parseLinks(start, goal);
        boolean result = parseLinks(links, goal);

        DijkstraShortestPath<String, DefaultEdge> pathFinder = new DijkstraShortestPath(g, start, goal);
        List<DefaultEdge> path = pathFinder.getPathEdgeList();

//        UnidrectedGraph<String, DefaultEdge> g
        PrintWriter out = new PrintWriter("linkDump.JSON", "UTF-8");
        System.out.println(result);
        for (Object edge : path) {
            out.println(edge);
        }
        out.close();

    }

}
