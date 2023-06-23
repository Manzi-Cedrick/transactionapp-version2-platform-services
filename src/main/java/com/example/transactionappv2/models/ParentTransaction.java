package com.example.transactionappv2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class ParentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String sender;

    public String receiver;

    public Number totalAmount;
}
