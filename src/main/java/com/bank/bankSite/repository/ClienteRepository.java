package com.bank.bankSite.repository;

import com.bank.bankSite.model.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Object> findByEmail(String email);
}
