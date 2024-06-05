package com.wajih.ecommerce.Controller;

import com.wajih.ecommerce.Entity.Article;
import com.wajih.ecommerce.Entity.Client;
import com.wajih.ecommerce.Entity.Commande;
import com.wajih.ecommerce.Exception.NotFoundException;
import com.wajih.ecommerce.Service.ArticleService;
import com.wajih.ecommerce.Service.ClientService;
import com.wajih.ecommerce.Service.CommandeService;
import com.wajih.ecommerce.dto.ReqRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Commands")
public class CommandeController {
    private final CommandeService commande;
    private final ClientService clientService;
    private final ArticleService articleService;



    @GetMapping("/user/{id}")
    public ResponseEntity<?> getCommandByUserId(@PathVariable("id") int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.getClient(id).getCommandes().get(0).getArticles());
        }
        catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
        }
    }


    @PostMapping("/addPTC")
    public ResponseEntity<?> addProduct(@RequestBody ReqRes req){
        Client client = clientService.getClient(req.getIdClient());
        Article article = articleService.finById(req.getIdArticle());
        System.out.println(client);
        System.out.println(article);
        if(!client.getCommandes().isEmpty()){
            client.getCommandes().get(0).getArticles().add(article);
        }
        else{
            Commande savedCommande= this.commande.save(new Commande());
            List<Article> ArtList = new ArrayList<>();
            ArtList.add(article);
            savedCommande.setArticles(ArtList);

            commande.save(savedCommande);
            List<Commande> ComList = new ArrayList<>();
            ComList.add(savedCommande);
            client.setCommandes(ComList);
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
    }
    @DeleteMapping ("/deleteFC")
    public ResponseEntity<?> delteProduct(@RequestBody ReqRes req){
        Client client = clientService.getClient(req.getIdClient());
        if(!client.getCommandes().isEmpty()){
            client.getCommandes().get(0).getArticles().remove(articleService.finById(req.getIdArticle()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
    }
    @DeleteMapping ("/deleteAllProduct")
    public ResponseEntity<?> delteAll(@RequestBody ReqRes req){
        Client client = clientService.getClient(req.getIdClient());
        if(!client.getCommandes().isEmpty()){
            client.getCommandes().get(0).setArticles(new ArrayList<Article>());
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
    }

}
