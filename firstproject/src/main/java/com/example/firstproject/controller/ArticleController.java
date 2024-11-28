package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired//원래 밑에 new로 객체를 생성해야하는데 오토와이어드로 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동연결한다.개꿀임
    // 핸들을 왼쪽오른쪽만 꺽으면 되면됨 우리는 몇도로 꺽어야되는지 몰라도됨
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newAricleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String CreateArticle(ArticleForm form) {
        System.out.println(form.toString());
        // 1. Dto를 변환! 엔티티로 변환하기!
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 2. 레포지토리에게 엔티티를 DB안에 저장하게 함!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "articles/new";
    }
}
