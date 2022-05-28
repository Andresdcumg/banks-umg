package com.bank.bankSite.controller;

import com.bank.bankSite.model.Banco;
import com.bank.bankSite.model.Cuenta;
import com.bank.bankSite.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.bankSite.repository.BancoRepository;
import com.bank.bankSite.repository.CuentaRepository;
import com.bank.bankSite.repository.ClienteRepository;
import com.bank.bankSite.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    /**
     * Get all products list.
     *
     * @return the list
     */
    @GetMapping("v2/clientes")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Create new cliente.
     *
     * @param cliente the cliente
     * @return the cliente
     */
    @PostMapping("v1/clientes")
    public Cliente createCliente(@Valid @RequestBody Cliente cliente) throws ResourceNotFoundException {
        return bancoRepository.findById(cliente.getIdBanco())
                .map(banco -> {
                    cliente.setBanco(banco);
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new ResourceNotFoundException("Bank not found with id " + cliente.getIdBanco()));
    }

    /**
     * Gets products by id.
     *
     * @param email the product id
     * @return the products by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("v2/clientes/{email}")
    public ResponseEntity<Cliente> getBanksById(@PathVariable(value = "email") String email)
            throws ResourceNotFoundException {
        Cliente cliente =
                (Cliente) clienteRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente not found on :: " + email));
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("v2/clientes/{id}/cuentas")
    public List<Cuenta> getAllCuentas(@PathVariable(value = "id") Long clienteId) throws ResourceNotFoundException {
        Cliente cliente =
                clienteRepository
                        .findById(clienteId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente not found on :: " + clienteId));

        return cuentaRepository.findByCliente(cliente);
    }

    /**
     * Crear cuenta a un usuario.
     *
     * @param clienteId     the product id
     * @param cuentaDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PostMapping("v2/clientes/{id}/cuentas")
    public ResponseEntity<Cuenta> createAccount(
            @PathVariable(value = "id") Long clienteId, @Valid @RequestBody Cuenta cuentaDetails)
            throws ResourceNotFoundException {

        Cliente cliente =
                clienteRepository
                        .findById(clienteId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cliente not found on :: " + clienteId));

        cuentaDetails.setCliente(cliente);
        final Cuenta nuevaCuenta = cuentaRepository.save(cuentaDetails);
        return ResponseEntity.ok(nuevaCuenta);
    }
}
