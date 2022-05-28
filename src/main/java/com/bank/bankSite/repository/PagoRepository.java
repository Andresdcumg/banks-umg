package com.bank.bankSite.repository;

import com.bank.bankSite.model.Pago;
import com.bank.bankSite.model.Cuenta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByCuenta(Cuenta cuenta);
}
