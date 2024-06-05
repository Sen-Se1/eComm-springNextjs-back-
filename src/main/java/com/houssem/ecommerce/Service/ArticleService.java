package com.wajih.ecommerce.Service;

import com.wajih.ecommerce.Entity.Article;
import com.wajih.ecommerce.Exception.NotFoundException;
import com.wajih.ecommerce.Repository.ArticleRepository;
import com.wajih.ecommerce.dto.ReqRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository article;

    public Article save(Article a){
        return article.saveAndFlush(a);
    }
    public Article finById(Long id){
        return article.findById(id).orElseThrow(
                ()-> new NotFoundException("Article Not Found")
        );
    }

    public void delete(Long id){
        article.delete(this.finById(id));
    }
    public List<Article> findAll(){
        return article.findAll();
    }

    public Article update( ReqRes res) {

        return article.saveAndFlush(res.getArticle());
    }

}
