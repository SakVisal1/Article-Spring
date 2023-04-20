package com.istad.springthymleaf.controller;

import com.istad.springthymleaf.model.Article;
import com.istad.springthymleaf.model.request.ArticleRequest;
import com.istad.springthymleaf.service.ArticleService;
import com.istad.springthymleaf.service.AuthorService;
import com.istad.springthymleaf.service.FileUploadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;

@Controller
public class ArticleController {
    ArticleService articleService;
    AuthorService authorService;
    FileUploadService fileUploadService;
    @Autowired
    ArticleController(ArticleService articleService,AuthorService authorService, FileUploadService fileUploadService){
        this.articleService = articleService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
    }


    @GetMapping("/all-article")
    public String getAllArticle(Model model){
        model.addAttribute("allArticles",articleService.getAllArticle().stream().sorted((a,b)-> b.getId()-a.getId()));
        return "all-article";
    }
    @GetMapping("/post/{postID}")
    public String getPostByID(@PathVariable int postID , Model model){
        model.addAttribute("article",articleService.getArticleById(postID));
        return "viewArticle";
    }
    @GetMapping("/form-add")
    public String getFormAdd(Model model){
        model.addAttribute("article",new ArticleRequest());
        model.addAttribute("authors",authorService.getAllAuthor());
        return "new-article";
    }

    @PostMapping("/handleAddArticle")
    public String handleAddArticle(@ModelAttribute("article") @Valid ArticleRequest article,
                                   BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            System.out.println("Error has Happened !");
//            model.addAttribute("article",new ArticleRequest());
            model.addAttribute("authors",authorService.getAllAuthor());
            return "new-article";
        }
        Article newArticle = new Article();
    try{
        String filenames ="http://localhost:8081/images/" + fileUploadService.uploadFile(article.getFile());
        System.out.println("Files name : " + filenames);
        newArticle.setImgUrl(filenames);
    }catch (Exception ex){
        newArticle.setImgUrl("https://react.semantic-ui.com/images/avatar/large/veronika.jpg");
        System.out.println("ERROR : " +ex.getMessage());
    }
        System.out.println("add is" + article);


        newArticle.setTitle(article.getTitle());
        newArticle.setDescription(article.getDescription());
//        newArticle.setImgUrl(article.getImgUrl());
        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == article.getId()).findFirst().orElse(null));

        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
        articleService.addArticle(newArticle);
        return "redirect:/all-article";
    }
}
