package com.bank.bankSite.controller;

import com.bank.bankSite.model.Cheque;
import com.bank.bankSite.model.Cliente;
import com.bank.bankSite.model.Cuenta;
import com.bank.bankSite.repository.ChequeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bank.bankSite.repository.CuentaRepository;
import com.bank.bankSite.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ChequeRepository chequeRepository;

    /**
     * Update product response entity.
     *
     * @param cuentaId      the product id
     * @param cuentaDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("v2/cuentas/{id}")
    public ResponseEntity<Cuenta> updateProduct(
            @PathVariable(value = "id") Long cuentaId, @Valid @RequestBody Cuenta cuentaDetails)
            throws ResourceNotFoundException {

        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        cuenta.setSaldo(cuenta.getSaldo() + cuentaDetails.getSaldo());
        final Cuenta updatedCuenta = cuentaRepository.save(cuenta);
        return ResponseEntity.ok(updatedCuenta);
    }

    @GetMapping("v2/cuentas/{id}/cheques")
    public List<Cheque> getAllCheques(@PathVariable(value = "id") Long cuentaId) throws ResourceNotFoundException {
        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        return chequeRepository.findByCuenta(cuenta);
    }

    /**
     * Delete product map.
     *
     * @param cuentaId the product id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("v2/cuentas/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long cuentaId) throws Exception {
        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        cuentaRepository.delete(cuenta);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    /**
     * @param cuentaId      the product id
     * @param chequeDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PostMapping("v2/cuentas/{id}/cheques")
    public ResponseEntity<Cheque> createCheque(
            @PathVariable(value = "id") Long cuentaId, @Valid @RequestBody Cheque chequeDetails)
            throws ResourceNotFoundException {

        Cuenta cuenta =
                cuentaRepository
                        .findById(cuentaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Cuenta not found on :: " + cuentaId));

        chequeDetails.setCuenta(cuenta);
        final Cheque chequeNuevo = chequeRepository.save(chequeDetails);
        return ResponseEntity.ok(chequeNuevo);
    }
}
