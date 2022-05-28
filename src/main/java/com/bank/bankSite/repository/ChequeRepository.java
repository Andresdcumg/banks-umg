package com.bank.bankSite.repository;

import com.bank.bankSite.model.Cheque;
import com.bank.bankSite.model.Cuenta;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    List<Cheque> findByCuenta(Cuenta cuenta);
}
