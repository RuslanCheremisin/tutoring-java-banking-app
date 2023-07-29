package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

import lombok.AllArgsConstructor;

import myjava.tutoring.tutoringjavarestfullbankingapp.model.TransactionType;
@AllArgsConstructor
public class TransactionDTO {
    private Integer accountNumber;
    private TransactionType type;
    private Long transactionAmount;
    private Integer dateTime;
}
