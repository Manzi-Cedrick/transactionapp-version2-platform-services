package com.example.transactionappv2.controllers;

import com.example.transactionappv2.exceptions.NotFoundException;
import com.example.transactionappv2.models.ChildInstallment;
import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ChildInstallmentsRepository;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
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
    private ParentTransactionRepository parentTransactionRepository;

    @GetMapping(path = "/child-installments")
    public List<ChildInstallment> getAllChildInstallments(){
        return childRepository.findAll();
    }

    @PostMapping(path = "/child-installments/record/new")
    public ChildInstallment postChildInstallment(@RequestBody ChildInstallment childInstallment) {
        ParentTransaction parentTransaction = parentTransactionRepository.findById(childInstallment.getParentId().getId())
                .orElseThrow(() -> new NotFoundException("ParentTransaction not found with id: " + childInstallment.getParentId().getId()));

        return childRepository.save(childInstallment);
    }

    @GetMapping("/child-installments/{id}")
    public ResponseEntity<ChildInstallment> getSingleChildInstallment(@PathVariable("id") int id) {
        Optional<ParentTransaction> parentTransaction = parentTransactionRepository.findById(id);
        if (parentTransaction.isPresent()) {
            Optional<ChildInstallment> childInstallment = childRepository.findByParentId(parentTransaction.get());
            if (childInstallment.isPresent()) {
                return ResponseEntity.ok(childInstallment.get());
            }
        }
        return ResponseEntity.notFound().build();
    }

}
