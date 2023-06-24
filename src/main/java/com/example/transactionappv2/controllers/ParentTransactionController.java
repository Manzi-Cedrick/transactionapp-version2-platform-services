package com.example.transactionappv2.controllers;

import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.services.ParentTransactionService;
import com.example.transactionappv2.util.PaginationTransactionRequest;
import com.example.transactionappv2.util.ResponseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParentTransactionController {
    @Autowired
    ParentTransactionService parentTransactionService;
    @GetMapping(path = "/")
    @ResponseBody
    public ResponseSerializer getInitialSetupInfo () {
        return new ResponseSerializer("Welcome at Transaction Application API Services. Thrilled to have you here.");
    }
    @GetMapping(path = "/transaction")
    public List<ParentTransaction> getAllTransaction(PaginationTransactionRequest paginationTransactionRequest){
        return parentTransactionService.getAllTransaction(paginationTransactionRequest);
    }

    @PostMapping(path = "/transaction/record/new")
    public ParentTransaction postTransaction(@RequestBody ParentTransaction transaction){
        return parentTransactionService.createTransaction(transaction);
    }
    @GetMapping(path = "/transaction/{id}")
    public Optional<ParentTransaction> listSingleTransaction(@PathVariable("id") int id){
        return parentTransactionService.listSingleTransaction(id);
    }
    @DeleteMapping(path = "/transaction/{id}")
    @ResponseBody
    public ResponseSerializer deleteData(@PathVariable("id") int id){
        return parentTransactionService.deleteTransaction(id);
    }
    @PutMapping("/transaction/{id}")
    public ParentTransaction updateTransaction(@PathVariable("id") int id, @RequestBody ParentTransaction transaction) {
        return parentTransactionService.updateTransaction(id, transaction);
    }

}
