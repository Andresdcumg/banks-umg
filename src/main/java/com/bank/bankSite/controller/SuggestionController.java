package com.bank.bankSite.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.bank.bankSite.model.Sugerencia;
import com.bank.bankSite.repository.SugerenciaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.bank.bankSite.exception.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class SuggestionController {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;


    /**
     * Create new sugerencia.
     *
     * @param sugerencia the sugerencia
     * @return the sugerencia
     */
    @PostMapping("/sugerencias")
    public Sugerencia createProduct(@Valid @RequestBody Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }
}
