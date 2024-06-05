package com.wajih.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @SequenceGenerator(name="CLIENT_SEQ", sequenceName="client_id_seq", allocationSize = 1)
    @Column( name="id" )
    private Integer id;
    @Column( name="numCl" )
    private int numCl;
    @Column( name="nomCl" )
    private String nomCl;
    @Column( name="prenomCl" )
    private String prenomCl;
    @Column( name="emailCl" )
    private String emailCl;
    @Column( name="passwordCl" )
    private String passwordCl;
    @Column( name="adresseCl" )
    private String adresseCl;
    @Column( name="telCl" )
    private int telCl;

    @OneToMany()
    private List<Commande> commandes;

}
