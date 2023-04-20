package com.istad.springthymleaf.service.serviceImpl;

import com.istad.springthymleaf.model.Article;
import com.istad.springthymleaf.repository.ArticleRepository;
import com.istad.springthymleaf.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    ArticleRepository articleRepository;
    ArticleServiceImpl(){
        articleRepository = new ArticleRepository();
    }
    @Override
    public List<Article> getAllArticle() {
        return articleRepository.getAllArticle();
    }

    @Override
    public Article getArticleById(int id) {
        return articleRepository.getArticleById(id);
    }

    @Override
    public void addArticle(Article article) {
        articleRepository.addNewArticle(article);
    }
}

