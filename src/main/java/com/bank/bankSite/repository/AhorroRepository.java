package com.bank.bankSite.repository;

import com.bank.bankSite.model.Ahorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AhorroRepository extends JpaRepository<Ahorro, Long> {
}
