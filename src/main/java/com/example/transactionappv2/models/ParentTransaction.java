package com.example.transactionappv2.models;

import jakarta.persistence.*;

import java.security.PublicKey;

@Entity
public class ParentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;

    public String sender;

    public String receiver;

    public Number totalAmount;
}
