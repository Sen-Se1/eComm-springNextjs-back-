package com.houssem.ecommerce.dto;

import com.houssem.ecommerce.Entity.Article;
import com.houssem.ecommerce.Entity.Client;
import com.houssem.ecommerce.Entity.Commande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRes {
    private Integer idClient;
    private Long idArticle;
    private int numCl;
    private String nomCl;
    private String prenomCl;
    private String adresseCl;
    private int telCl;
    private Client client;
    private Commande commande;
    private Article article;


}
