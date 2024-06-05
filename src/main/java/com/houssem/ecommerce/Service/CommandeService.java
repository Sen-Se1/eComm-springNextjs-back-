package com.wajih.ecommerce.Service;


import com.wajih.ecommerce.Entity.Commande;
import com.wajih.ecommerce.Exception.NotFoundException;
import com.wajih.ecommerce.Repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommandeService {
    private final CommandeRepository commande;
    public List<Commande> getAllCommands(){
        return commande.findAll();
    }
    public Commande getCommande(int id){
        return commande.findById(id).orElseThrow(
                ()-> new NotFoundException("Commande Not Found")
        );
    }
    public Commande save(Commande c){
        return commande.saveAndFlush(c);
    }
    public void delete(int id){
        commande.delete(this.getCommande(id));
    }
}
