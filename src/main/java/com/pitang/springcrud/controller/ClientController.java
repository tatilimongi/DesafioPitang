package com.pitang.springcrud.controller;

import com.pitang.springcrud.dto.ClientDTO;
import com.pitang.springcrud.entity.Client;
import com.pitang.springcrud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public String addClient(@RequestBody Client client){
        clientService.addClient(client);

        return "cliente adicionado com sucesso";
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/get")
    public Client getClient(@RequestParam UUID id){
        return clientService.getClient(id);
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable UUID id, @RequestBody Client client){
       return clientService.updateClient(id, client);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable UUID id){
        clientService.deleteClient(id);

        return ResponseEntity.ok("Cliente com o ID " + id + " foi deletado com sucesso!");
    }
    @PatchMapping("/update-credit/{id}")
    public ResponseEntity<String> updateCredit(@PathVariable UUID id, @RequestBody ClientDTO clientDTO){
        clientService.updateCredit(id, clientDTO);

        return ResponseEntity.ok("Cliente com o ID " + id + " teve seu crédito atualizado com sucesso!");
    }
    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activateClient(@PathVariable UUID id){
        clientService.activateClient(id);
        return ResponseEntity.ok("Cliente com o ID " + id + " foi ativado com sucesso!");
    }
}
