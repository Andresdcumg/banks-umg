package com.bank.bankSite.controller;

import com.bank.bankSite.exception.ResourceNotFoundException;
import com.bank.bankSite.model.Cliente;
import com.bank.bankSite.repository.BancoRepository;
import com.bank.bankSite.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BancoRepository bancoRepository;

    /**
     * Create new sugerencia.
     *
     * @param cliente the cliente
     * @return the cliente
     */
    @PostMapping("/clientes")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) throws ResourceNotFoundException {
        return bancoRepository.findById(cliente.getIdBanco())
                .map(banco -> {
                    cliente.setBanco(banco);
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new ResourceNotFoundException("Bank not found with id " + cliente.getIdBanco()));
    }
}
