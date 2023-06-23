package com.example.transactionappv2.controllers;

import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import com.example.transactionappv2.util.ResponseSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
