package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
 * Created by yx on 2018/7/8.
 */
public interface ArticleService {

    public Map<String,Object> queryArticleByPage(int nowPage, int pageSize);

    public int addArticle(Article article);
}
