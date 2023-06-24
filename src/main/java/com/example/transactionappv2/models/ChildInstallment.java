package com.example.transactionappv2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class ChildInstallment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ParentTransaction parentId;

    private Number paidAmount;
}
