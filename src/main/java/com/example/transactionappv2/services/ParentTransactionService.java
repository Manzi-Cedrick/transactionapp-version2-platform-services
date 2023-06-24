package com.example.transactionappv2.services;

import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import com.example.transactionappv2.util.PaginationTransactionRequest;
import com.example.transactionappv2.util.PaginationUtils;
import com.example.transactionappv2.util.ResponseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentTransactionService {
    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    public List<ParentTransaction> getAllTransaction(PaginationTransactionRequest paginationTransactionRequest) {
        Pageable pageable = PaginationUtils.createPageable(paginationTransactionRequest);
        Page<ParentTransaction> transactionPage = parentTransactionRepository.findAll(pageable);
        return transactionPage.getContent();
    }

    public ParentTransaction createTransaction(ParentTransaction transaction) {
        return parentTransactionRepository.save(transaction);
    }

    public Optional<ParentTransaction> listSingleTransaction(int id) {
        return parentTransactionRepository.findById(id);
    }

    public ResponseSerializer deleteTransaction(int id) {
        parentTransactionRepository.deleteById(id);
        return new ResponseSerializer("Transaction with id " + id + " has been deleted");
    }

    public ParentTransaction updateTransaction(int id, ParentTransaction transaction) {
        Optional<ParentTransaction> optionalTransaction = parentTransactionRepository.findById(id);
        if (optionalTransaction.isEmpty()) {
            return null;
        }

        ParentTransaction existingTransaction = optionalTransaction.get();

        if (transaction.getSender() != null) {
            existingTransaction.setSender(transaction.getSender());
        }
        if (transaction.getReceiver() != null) {
            existingTransaction.setReceiver(transaction.getReceiver());
        }
        if (transaction.getTotalAmount() != null) {
            existingTransaction.setTotalAmount(transaction.getTotalAmount());
        }

        return parentTransactionRepository.save(existingTransaction);
    }
}
