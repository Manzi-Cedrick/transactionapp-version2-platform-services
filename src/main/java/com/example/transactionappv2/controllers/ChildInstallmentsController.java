package com.example.transactionappv2.controllers;

import com.example.transactionappv2.exceptions.NotFoundException;
import com.example.transactionappv2.models.ChildInstallment;
import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ChildInstallmentsRepository;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import com.example.transactionappv2.services.ChildInstallmentService;
import com.example.transactionappv2.services.ParentTransactionService;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChildInstallmentsController {
    @Autowired
    ChildInstallmentsRepository childRepository;

    @Autowired
    ChildInstallmentService childInstallmentService;
    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    @GetMapping(path = "/child-installments")
    public List<ChildInstallment> retrieveAllInstallments(){
        return childInstallmentService.getAllInstallments();
    }

    @PostMapping(path = "/child-installments/record/new")
    public ResponseEntity<ChildInstallment> postChildInstallment(@RequestBody ChildInstallment childInstallment) {
        return childInstallmentService.addChildInstallment(childInstallment);
    }

    @GetMapping("/child-installments/{parentId}")
    public ResponseEntity<ChildInstallment> getSingleChildInstallment(@PathVariable("parentId") int parentId) {
        return childInstallmentService.getSingleChildInstallment(parentId);
    }

}
