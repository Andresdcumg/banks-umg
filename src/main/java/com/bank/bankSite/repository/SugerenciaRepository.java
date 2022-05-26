package com.bank.bankSite.repository;

import com.bank.bankSite.model.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {
}
