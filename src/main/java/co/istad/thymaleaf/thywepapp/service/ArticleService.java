package co.istad.thymaleaf.thywepapp.service;

import co.istad.thymaleaf.thywepapp.model.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    boolean save(Article article, MultipartFile file);
}
