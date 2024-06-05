package com.houssem.ecommerce.Service;

import com.houssem.ecommerce.Entity.Client;
import com.houssem.ecommerce.Exception.NotFoundException;
import com.houssem.ecommerce.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository client;
    public List<Client> getAllClients(){
        return client.findAll();
    }
    public Client getClient(int id){
        return client.findById(id).orElseThrow(
                ()-> new NotFoundException("Client Not Found")
        );
    }
    public Client save(Client c){
        Client c1 = client.saveAndFlush(c);
        c1.setNumCl(c1.getId());
        return client.saveAndFlush(c1);
    }
    public void delete(int id){
        Client c = client.findById(id).orElseThrow(
                ()-> new NotFoundException("Client Not Found")
        );
        client.delete(c);
    }
    public Client getByEmail(String email){
        try {
            return client.findByEmailCl(email);
        }
        catch (Exception e){
            return new Client();
        }

    }
}
