package com.bank.bankSite.controller;

import com.bank.bankSite.model.Sugerencia;
import org.springframework.web.bind.annotation.*;
import com.bank.bankSite.repository.SugerenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Sugerencia createSuggestion(@Valid @RequestBody Sugerencia sugerencia) {
        return sugerenciaRepository.save(sugerencia);
    }
}
