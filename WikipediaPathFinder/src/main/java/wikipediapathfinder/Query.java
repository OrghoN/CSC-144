/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikipediapathfinder;

import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

/**
 *
 * @author orgho
 */
public class Query {

    public static void main(String[] args) {
        MediaWikiBot wikiBot = new MediaWikiBot("https://en.wikipedia.org/w/");
        Article article = wikiBot.getArticle("42");
        System.out.println(article.getText());
    }

}
