package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yx on 2018/7/8.
 */
public interface ArticleDao {
        public List<Article> selectArticleByPage(@Param("start") int start, @Param("end") int end);

        public int count();

        public int insertArticle(Article article);
}
