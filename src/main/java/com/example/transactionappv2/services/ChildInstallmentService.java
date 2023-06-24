package com.example.transactionappv2.services;

import com.example.transactionappv2.models.ChildInstallment;
import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ChildInstallmentsRepository;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ChildInstallmentService {
    @Autowired
    private ChildInstallmentsRepository childInstallmentsRepository;

    @Autowired
    private ParentTransactionRepository parentTransactionRepository;
    public List<ChildInstallment> getAllInstallments(){
        return childInstallmentsRepository.findAll();
    }

    public ResponseEntity<ChildInstallment> addChildInstallment(ChildInstallment childInstallment) {
        Integer parentId = childInstallment.getParentId().getId();
        ParentTransaction parentTransaction = parentTransactionRepository.findById(parentId).orElse(null);
        if (parentTransaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        childInstallment.setParentId(parentTransaction);
        ChildInstallment savedChildInstallment = childInstallmentsRepository.save(childInstallment);

        return new ResponseEntity<>(savedChildInstallment, HttpStatus.CREATED);
    }

    public ResponseEntity<ChildInstallment> getSingleChildInstallment(int id) {
        ParentTransaction parentTransaction = parentTransactionRepository.findById(id).orElse(null);
        if (parentTransaction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ChildInstallment childInstallment = childInstallmentsRepository.findByParentId(parentTransaction);
        return new ResponseEntity<>(childInstallment, HttpStatus.OK);
    }
}
