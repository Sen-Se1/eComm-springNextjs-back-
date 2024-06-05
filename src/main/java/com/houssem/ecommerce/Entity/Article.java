package com.houssem.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ART_SEQ")
    @Column( name="idArt" )
    private Long idArt;
    @Column( name="codeArt" )
    private String codeArt;
    @Column( name="nomArt" )
    private String nomArt;
    @Column( name="imgArt",length = 555)
    private String imgArt;
    @Column( name="desArt",length = 1500)
    private String desArt;
    @Column( name="couleurArt" )
    private String couleurArt;
    @Column( name="puartArt" )
    private float puartArt;
    @Column( name="qtestockArt" )
    private int qtestockArt;

}
