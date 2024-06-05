package com.houssem.ecommerce.Service;


import com.houssem.ecommerce.Exception.NotFoundException;
import com.houssem.ecommerce.Repository.CommandeRepository;
import com.houssem.ecommerce.Entity.Commande;
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
