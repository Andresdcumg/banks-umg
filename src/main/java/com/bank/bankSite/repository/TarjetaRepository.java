package com.bank.bankSite.repository;

import com.bank.bankSite.model.Cliente;
import com.bank.bankSite.model.Tarjeta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    List<Tarjeta> findByCliente(Cliente cliente);
}
