package com.houssem.ecommerce.Controller;

import com.houssem.ecommerce.Entity.Article;
import com.houssem.ecommerce.Exception.NotFoundException;
import com.houssem.ecommerce.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(path="/Articles")
public class ArticleController {
    private final ArticleService article;

    @GetMapping
    public HashMap<String, List<Article>> getAll() {
        HashMap<String, List<Article>> res = new HashMap<>();
        res.put("Result", article.findAll());
        return res;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable("id") Long id){
        try{
            HashMap<String,Article> message = new HashMap<>();
            message.put("Article", article.finById(id));
            return ResponseEntity.status(HttpStatus.OK).body(message);

        }
        catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Article a){
        return ResponseEntity.status(HttpStatus.OK).body(article.save(a));
    }



}
