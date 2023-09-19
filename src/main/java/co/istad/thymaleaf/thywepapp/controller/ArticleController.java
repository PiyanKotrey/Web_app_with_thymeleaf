package co.istad.thymaleaf.thywepapp.controller;

import co.istad.thymaleaf.thywepapp.model.Article;
import co.istad.thymaleaf.thywepapp.service.ArticleService;
//import co.istad.thymaleaf.thywepapp.service.FileUploadService;
import co.istad.thymaleaf.thywepapp.service.FileUploadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    String viewArticle(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "pages/article/article";
    }
    @GetMapping("/new")
    String viewArticleNew( Article article, Model model){
        model.addAttribute("article",article);
        return "pages/article/article-new";
    }
    @PostMapping (value = "/new")
    String doSaveArticle(@ModelAttribute @Valid Article article, BindingResult result,
                         @RequestParam("thumbnailFile") MultipartFile file, Model model){
        if (result.hasErrors()){
            model.addAttribute("article",article);
            return "pages/article/article-new";
        }
        boolean isSucces = articleService.save(article,file);
        if (isSucces){
            return "redirect:/article";
        }
        return "redirect:/article/article/new";
    }

}
