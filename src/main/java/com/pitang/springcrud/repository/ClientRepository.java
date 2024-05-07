package com.pitang.springcrud.repository;

import com.pitang.springcrud.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;


public interface ClientRepository extends JpaRepository<Client, UUID>{


}
