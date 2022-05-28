package com.bank.bankSite.repository;

import com.bank.bankSite.model.Cliente;
import com.bank.bankSite.model.Prestamo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByCliente(Cliente cliente);
}
