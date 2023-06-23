package com.example.transactionappv2.repositories;

import com.example.transactionappv2.models.ParentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentTransactionRepository extends JpaRepository<ParentTransaction, UUID> {

}