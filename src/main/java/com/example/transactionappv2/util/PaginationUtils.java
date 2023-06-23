package com.example.transactionappv2.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {
    public static Pageable createPageable(PaginationTransactionRequest paginationTransactionRequest){
        Sort sort = Sort.unsorted();
        if (paginationTransactionRequest.getSortField() != null) {
            if (paginationTransactionRequest.getSortDirection() != null) {
                Sort.Direction direction = Sort.Direction.fromString(paginationTransactionRequest.getSortDirection().toString());
                sort = Sort.by(direction, paginationTransactionRequest.getSortField());
            } else {
                sort = Sort.by(paginationTransactionRequest.getSortField());
            }
        }
        return PageRequest.of(paginationTransactionRequest.getPage(), paginationTransactionRequest.getSize(), sort);
    }
}
