package com.wajih.ecommerce.Service;

import com.wajih.ecommerce.Entity.Client;
import com.wajih.ecommerce.Exception.NotFoundException;
import com.wajih.ecommerce.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
