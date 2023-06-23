package com.example.transactionappv2.util;

import com.example.transactionappv2.enums.SortDirection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationTransactionRequest {
    private int page;
    private int size;
    private String sortField;
    private SortDirection sortDirection;
}
