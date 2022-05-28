package com.bank.bankSite.controller;

import com.bank.bankSite.exception.ResourceNotFoundException;
import com.bank.bankSite.model.Banco;
import com.bank.bankSite.model.Servicio;
import com.bank.bankSite.repository.BancoRepository;
import com.bank.bankSite.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;

    /**
     * Get all products list.
     *
     * @return the list
     */
    @GetMapping("/servicios")
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

    /**
     * Gets products by id.
     *
     * @param servicioId the product id
     * @return the products by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/servicios/{id}")
    public ResponseEntity<Servicio> getServiciosById(@PathVariable(value = "id") Long servicioId)
            throws ResourceNotFoundException {
        Servicio servicio =
                servicioRepository
                        .findById(servicioId)
                        .orElseThrow(() -> new ResourceNotFoundException("Servicio not found on :: " + servicioId));
        return ResponseEntity.ok().body(servicio);
    }

    /**
     * Create new product.
     *
     * @param servicio the product
     * @return the product
     */
    @PostMapping("/servicios")
    public Servicio createServicio(@Valid @RequestBody Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    /**
     * Update product response entity.
     *
     * @param servicioId      the product id
     * @param servicioDetails the product details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/servicios/{id}")
    public ResponseEntity<Servicio> updateServicio(
            @PathVariable(value = "id") Long servicioId, @Valid @RequestBody Servicio servicioDetails)
            throws ResourceNotFoundException {

        Servicio servicio =
                servicioRepository
                        .findById(servicioId)
                        .orElseThrow(() -> new ResourceNotFoundException("Servicio not found on :: " + servicioId));

        servicio.setTipo(servicioDetails.getTipo());
        servicio.setVerificador(servicioDetails.getVerificador());
        final Servicio updatedServicio = servicioRepository.save(servicio);
        return ResponseEntity.ok(updatedServicio);
    }

    /**
     * Delete product map.
     *
     * @param servicioId the product id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/servicios/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long servicioId) throws Exception {
        Servicio servicio =
                servicioRepository
                        .findById(servicioId)
                        .orElseThrow(() -> new ResourceNotFoundException("Servicio not found on :: " + servicioId));

        servicioRepository.delete(servicio);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
