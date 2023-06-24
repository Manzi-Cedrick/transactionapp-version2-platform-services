package com.example.transactionappv2.util;

import com.example.transactionappv2.models.ChildInstallment;
import com.example.transactionappv2.models.ParentTransaction;
import com.example.transactionappv2.repositories.ChildInstallmentsRepository;
import com.example.transactionappv2.repositories.ParentTransactionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class Runner implements ApplicationRunner {

    @Autowired
    private ChildInstallmentsRepository childInstallmentsRepository;
    @Autowired
    private ParentTransactionRepository parentTransactionRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World from Application Runner");

        try {
            InputStream inputStream = getClass().getResourceAsStream("/mocks/parent.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<ParentTransaction> parentTransactions = objectMapper.readValue(inputStream, new TypeReference<List<ParentTransaction>>() {
            });
            parentTransactionRepository.saveAll(parentTransactions);
            System.out.println("Parent Transactions saved successfully");
            for (ParentTransaction parentTransaction : parentTransactions) {
                if (isParentTransactionFinished(parentTransaction)) {
                    InputStream childInputStream = getClass().getResourceAsStream("/mocks/child.json");
                    List<ChildInstallment> childInstallments = objectMapper.readValue(childInputStream, new TypeReference<List<ChildInstallment>>() {
                    });
                    for (ChildInstallment childInstallment : childInstallments) {
                        childInstallment.setParentId(parentTransaction);
                    }
                    childInstallmentsRepository.saveAll(childInstallments);
                    System.out.println("Child Installments saved successfully for Parent Transaction ID: " + parentTransaction.getId());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private boolean isParentTransactionFinished(ParentTransaction parentTransaction) {
        return parentTransaction.getSender() != null && parentTransaction.getReceiver() != null && parentTransaction.getTotalAmount() != null;
    }
}
