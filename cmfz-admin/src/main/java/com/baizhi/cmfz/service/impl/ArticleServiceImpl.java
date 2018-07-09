package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yx on 2018/7/8.
 */
@Service
@Transactional
    public class ArticleServiceImpl implements ArticleService {
        @Autowired
        private ArticleDao articleDao;
        @Override
    public int addArticle(Article article) {
        int i = articleDao.insertArticle(article);
        return i;
    }
}
