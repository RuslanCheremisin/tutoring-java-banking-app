package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransferDTO {
    private final Integer accountFrom;
    private final Integer accountTo;
    private final Long amount;
    private final Integer dateTime;
}
