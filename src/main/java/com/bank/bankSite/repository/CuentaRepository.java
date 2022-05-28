package com.bank.bankSite.repository;

import com.bank.bankSite.model.Cliente;
import com.bank.bankSite.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByCliente(Cliente cliente);
}
