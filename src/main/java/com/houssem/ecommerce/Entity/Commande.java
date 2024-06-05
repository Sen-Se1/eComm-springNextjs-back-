package com.wajih.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Table
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COM_SEQ")
    @SequenceGenerator(name="COM_SEQ", sequenceName="com_id_seq", allocationSize = 1)
    @Column( name="idCom" )
    private Integer id;
    @Column( name="numCom" )
    private int numCom;
    @Column( name="dateCom" )
    private Date dateCom;
    @ManyToMany
    @JoinTable(
            name = "commande_article",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles;

}
