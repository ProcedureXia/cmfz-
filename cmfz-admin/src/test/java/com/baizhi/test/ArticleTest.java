package com.baizhi.test;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by yx on 2018/7/10.
 */
public class ArticleTest {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ArticleService articleService = (ArticleService) applicationContext.getBean("articleServiceImpl");
        Article article = new Article();
        article.setArticleId(21);
        article.setArticleName("aaa");
        article.setArticleContent("123456");
        article.setArticleAddress("www.baizhi.com");
        article.setArticleStatus("上架");
        article.setArticleDate(new Date());
        article.setMasterId(1);
        //System.out.println(articleService.addArticle(article));

    }
}
