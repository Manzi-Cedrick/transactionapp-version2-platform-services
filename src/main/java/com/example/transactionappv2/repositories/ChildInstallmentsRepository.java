package com.example.transactionappv2.repositories;

import com.example.transactionappv2.models.ChildInstallment;
import com.example.transactionappv2.models.ParentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildInstallmentsRepository extends JpaRepository<ChildInstallment,Integer> {
    Optional<ChildInstallment> findByParentId(ParentTransaction transaction);
}
