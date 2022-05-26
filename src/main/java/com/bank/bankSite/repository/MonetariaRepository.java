package com.bank.bankSite.repository;

import com.bank.bankSite.model.Monetaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonetariaRepository extends JpaRepository<Monetaria, Long> {
}
