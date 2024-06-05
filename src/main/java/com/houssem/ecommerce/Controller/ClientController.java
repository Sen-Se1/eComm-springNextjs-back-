package com.houssem.ecommerce.Controller;

import com.houssem.ecommerce.Entity.Client;
import com.houssem.ecommerce.Exception.NotFoundException;
import com.houssem.ecommerce.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/Client")
public class ClientController {
    //@Autowired
    private final ClientService client;
    @GetMapping()
    public List<Client> getAll(){
        return client.getAllClients();
    }

    @GetMapping("/{id}")
    public HashMap<String,?> getClientById(@PathVariable("id") int id){
        try{
            HashMap<String, Client> hashMap = new HashMap<>();
            hashMap.put("Client",client.getClient(id));
            return hashMap;
        }
        catch (NotFoundException e){
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("Error",e.toString());
            return hashMap;
        }


    }
    @PostMapping("/save")
    public Client save(@RequestBody Client c){
        return client.save(c);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        try {
            client.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("CLIENT DELETED");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public HashMap<String,?> login(@RequestBody Client c){
        Client c1 =client.getByEmail(c.getEmailCl());
        if(c1 != null){
            if(c1.getPasswordCl().equals(c.getPasswordCl())){
                HashMap<String,Client> res = new HashMap<>();
                res.put("Client",c1);
                return  res;
            }
            else {
                HashMap<String,String> res = new HashMap<>();
                res.put("Error","Email Or Password Not Valid");
                return  res;
            }
        }
        else {
            HashMap<String,String> res = new HashMap<>();
            res.put("Error","Email Or Password Not Valid");
            return  res;
        }
    }


}
