package com.example.transactionappv2.controllers;

import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import com.example.transactionappv2.util.ResponseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParentTransactionController {
    @Autowired
    ParentTransactionRepository parentRepository;

    @GetMapping(path = "/")
    @ResponseBody
    public ResponseSerializer getInitialSetupInfo () {
        return new ResponseSerializer("Welcome at Transaction Application API Services. Thrilled to have you here.");
    }
    @GetMapping(path = "/transaction")
    public List<ParentTransaction> getAllTransaction(){
        return parentRepository.findAll();
    }
    @PostMapping(path = "/transaction/record/new")
    public ParentTransaction postTransaction(@RequestBody ParentTransaction transaction){
        return parentRepository.save(transaction);
    }
    @GetMapping(path = "/transaction/{id}")
    public Optional<ParentTransaction> listSingleTransaction(@PathVariable("id") int id){
        return parentRepository.findById(id);
    }
    @DeleteMapping(path = "/transaction/{id}")
    @ResponseBody
    public ResponseSerializer deleteData(@PathVariable("id") int id){
        parentRepository.deleteById(id);
        return new ResponseSerializer("Transaction Removed");
    }
    @PutMapping("/transaction/{id}")
    public ParentTransaction updateTransaction(@PathVariable("id") int id, @RequestBody ParentTransaction transaction) {
        Optional<ParentTransaction> optionalTransaction = parentRepository.findById(id);
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

        return parentRepository.save(existingTransaction);
    }

}
