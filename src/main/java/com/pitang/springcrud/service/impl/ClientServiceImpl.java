package com.pitang.springcrud.service.impl;

import com.pitang.springcrud.dto.ClientDTO;
import com.pitang.springcrud.entity.Client;
import com.pitang.springcrud.repository.ClientRepository;
import com.pitang.springcrud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(UUID id) {
        //Checa se existe ou não existe um cliente com o id inserido
        Client client = clientRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "id invalido " + id));

        return client;
    }

    @Override
    public Client updateClient(UUID id, Client client) {
        //Checa se existe ou não existe um cliente com o id inserido

        Client existingCLient = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "id invalido " + id));
        if(existingCLient != null && existingCLient.getStatus().equals("Ativo")){
            client.setId(id);
            return clientRepository.save(client);
        }   else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível atualizar um cliente inativo");
        }



    }

    @Override
    public void deleteClient(UUID id) {
        //Checa se existe ou não existe um cliente com o id inserido
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "id invalido " + id));
        if (existingClient != null && existingClient.getStatus().equals("Ativo")) {
            clientRepository.delete(existingClient);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível deletar um cliente inativo");
        }

    }

    @Override
    public void updateCredit(UUID id, ClientDTO clientDTO) {
        //Checa se existe ou não existe um cliente com o id inserido
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "id invalido " + id));
        if (client != null && client.getStatus().equals("Ativo")) {
            client.setCreditoPagina(clientDTO.getCreditoPagina());
            clientRepository.save(client);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível atualizar o crédito de um cliente inativo.");
        }
    }
    @Override
    public void activateClient(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "id invalido " + id));
        if("Ativo".equals(client.getStatus())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Cliente ja esta ativo");
        }
        client.setStatus("Ativo");
        clientRepository.save(client);
    }
}
