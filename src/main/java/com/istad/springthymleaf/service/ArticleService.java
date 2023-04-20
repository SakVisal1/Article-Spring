package com.istad.springthymleaf.service;

import com.istad.springthymleaf.model.Article;
import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleById(int id);
    void addArticle(Article article);
}
