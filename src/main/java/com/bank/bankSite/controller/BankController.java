package com.bank.bankSite.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.bank.bankSite.model.Banco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.bankSite.repository.BancoRepository;
import com.bank.bankSite.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BankController {

    @Autowired
    private BancoRepository bancoRepository;

    /**
     * Get all products list.
     *
     * @return the list
     */
    @GetMapping("/bancos")
    public List<Banco> getAllBanks() {
        return bancoRepository.findAll();
    }

    /**
     * Gets products by id.
     *
     * @param bankId the product id
     * @return the products by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/bancos/{id}")
    public ResponseEntity<Banco> getBanksById(@PathVariable(value = "id") Long bankId)
            throws ResourceNotFoundException {
        Banco banco =
                bancoRepository
                        .findById(bankId)
                        .orElseThrow(() -> new ResourceNotFoundException("Bank not found on :: " + bankId));
        return ResponseEntity.ok().body(banco);
    }

    /**
     * Create new product.
     *
     * @param banco the product
     * @return the product
     */
    @PostMapping("/bancos")
    public Banco createBank(@Valid @RequestBody Banco banco) {
        return bancoRepository.save(banco);
    }

    /**
     * Update product response entity.
     *
     * @param productId      the product id
     * @param productDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/bancos/{id}")
    public ResponseEntity<Banco> updateProduct(
            @PathVariable(value = "id") Long productId, @Valid @RequestBody Banco productDetails)
            throws ResourceNotFoundException {

        Banco banco =
                bancoRepository
                        .findById(productId)
                        .orElseThrow(() -> new ResourceNotFoundException("Bank not found on :: " + productId));

        banco.setNombre(productDetails.getNombre());
        banco.setDireccion(productDetails.getDireccion());
        banco.setTelefono(productDetails.getTelefono());
        final Banco updatedBanco = bancoRepository.save(banco);
        return ResponseEntity.ok(updatedBanco);
    }

    /**
     * Delete product map.
     *
     * @param productId the product id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/bancos/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) throws Exception {
        Banco banco =
                bancoRepository
                        .findById(productId)
                        .orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));

        bancoRepository.delete(banco);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
