package com.pitang.springcrud.service;

import com.pitang.springcrud.dto.ClientDTO;
import com.pitang.springcrud.entity.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    void addClient(Client client);

    List<Client> getClients();

    Client getClient(UUID id);

    Client updateClient(UUID id, Client client);

    void deleteClient(UUID id);

    void updateCredit(UUID id, ClientDTO clientDTO);

    void activateClient(UUID id);
}
