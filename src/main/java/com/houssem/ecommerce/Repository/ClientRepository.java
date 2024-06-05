package com.wajih.ecommerce.Repository;

import com.wajih.ecommerce.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmailCl(String emailCl);
}
