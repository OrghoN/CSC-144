/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

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

    public static void main(String[] args) {
//        MediaWikiBot wikiBot = new MediaWikiBot("https://en.wikipedia.org/w/");
//        Article article = wikiBot.getArticle("42");
//        System.out.println(article.getText());

        HttpActionClient testee = HttpActionClient.builder()
                .withClient(HttpClientBuilder.create().build())
                .withUrl("https://www.wikipedia.org/w/")
                .build();
        Get search = new ApiRequestBuilder()
                .formatJson()
                .action("query")
                .param("list", "search")
                .param("srsearch", "wikipedia")
                .param("limit", "1")
                .param("maxlax", "-1")
                .buildGet();

        Get parse = new ApiRequestBuilder()
                .formatJson()
                .action("parse")
                .param("page", "San_Francisco")
                .param("prop", "links")
                .buildGet();

        ResponseHandler<String> getResponse = ContentProcessableBuilder.create(testee).withActions(search).build();
        ResponseHandler<String> getParse = ContentProcessableBuilder.create(testee).withActions(parse).build();

//        System.out.println(testee.performAction(getResponse));
        testee.performAction(getResponse);
        System.out.println(getParse.get());

    }

}
