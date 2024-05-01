package com.pitang.service;

import com.pitang.entity.Cliente;
import com.pitang.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> findAllClientes() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findClienteById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
