package co.istad.thymaleaf.thywepapp.controller;

import co.istad.thymaleaf.thywepapp.model.Article;
import co.istad.thymaleaf.thywepapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ArticleService articleService;
    @GetMapping("/")
    String viewHome(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "pages/index";
    }
}
