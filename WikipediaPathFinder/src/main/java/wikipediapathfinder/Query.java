/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.jwbf.core.actions.ContentProcessableBuilder;
import net.sourceforge.jwbf.core.actions.Get;
import net.sourceforge.jwbf.core.actions.HttpActionClient;
import net.sourceforge.jwbf.core.actions.ResponseHandler;
import net.sourceforge.jwbf.mediawiki.ApiRequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author orgho
 */
public class Query {

    static HttpActionClient testee = HttpActionClient.builder()
            .withClient(HttpClientBuilder.create().build())
            .withUrl("https://www.wikipedia.org/w/")
            .build();

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

        List<String> links = new ArrayList<String>();
        while (m.find()) {
            String link = m.group().replace("\"", "").replace("*:", "");
            if (!(link.contains("Template:") || link.contains("Category:"))) {
                links.add(link);
            }
        }

        return links;
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        List<String> links = parseLinks("Dhaka");

//        UnidrectedGraph<String, DefaultEdge> g
        PrintWriter out = new PrintWriter("linkDump.JSON", "UTF-8");
        out.println(links);
        out.close();

    }

}
