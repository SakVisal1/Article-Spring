package com.istad.springthymleaf.repository;

import com.istad.springthymleaf.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{
        add(new Article(1001,"Chat GPT","new evolution of problem","https://i.kinja-img.com/gawker-media/image/upload/c_fit,f_auto,g_center,q_60,w_645/e22ffced391aa9d154c732542347b84e.jpg",
                new AuthorRepository().getAllAuthors().get(0)));
        add(new Article(1002,"Cat GPT","new evolution of problem resolve from developer","https://d1lss44hh2trtw.cloudfront.net/resize?type=webp&url=https%3A%2F%2Fshacknews-www.s3.amazonaws.com%2Fassets%2Farticle%2F2022%2F01%2F26%2Fbayc-racism_feature.jpg&width=1032&sign=f4LcTNAnRNHFwIXtO9O9WaQU78Ny6X5mT-ArULv2gp4",
                new AuthorRepository().getAllAuthors().get(1)));
        add(new Article(1003,"Dog GPT","new evolution of problem resolve from developer and designer","https://www.themonthly.com.au/sites/default/files/styles/featured_essay/public/Cooke_0322_1140x700.jpg?itok=HlTQ0rju",
                new AuthorRepository().getAllAuthors().get(2)));
        add(new Article(1004,"Meow GPT","new evolution of problem resolve from designer and photoshop","https://nftnewspro.com/wp-content/uploads/2021/09/shakhesh-1.jpg",
                new AuthorRepository().getAllAuthors().get(3)));
    }};

    public List<Article> getAllArticle(){
        return articleList;
    }
    public Article getArticleById(int id){
        return articleList.stream().filter(e -> e.getId()==id).findFirst().orElse(null);
    }
    public void addNewArticle(Article article){
        articleList.add(article);
    }
}
