package com.example.transactionappv2.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseSerializer extends Throwable {
    private String message;
}
