package com.pitang.controller;

import com.pitang.entity.Cliente;
import com.pitang.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteService.findAllClientes();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = clienteService.findClienteById(id);
		return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		Cliente createdCliente = clienteService.saveCliente(cliente);
		return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		Cliente updatedCliente = clienteService.saveCliente(cliente);
		return new ResponseEntity<>(updatedCliente, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
		clienteService.deleteCliente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
