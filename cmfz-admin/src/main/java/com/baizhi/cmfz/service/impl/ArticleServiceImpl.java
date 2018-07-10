package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yx on 2018/7/8.
 */
@Service
@Transactional
    public class ArticleServiceImpl implements ArticleService {
        @Autowired
        private ArticleDao articleDao;

    @Transactional(isolation= Isolation.READ_COMMITTED,propagation= Propagation.SUPPORTS,readOnly=true)
    public Map<String, Object> queryArticleByPage(int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        List<Article> list = articleDao.selectArticleByPage(start, end);
        Map<String,Object> map = new HashMap<String ,Object>();
        int count = articleDao.count();
        map.put("total",count);
        map.put("rows", list);
        return map;
    }

    @Override
    public int addArticle(Article article) {
        int i = articleDao.insertArticle(article);
        return i;
    }
}
