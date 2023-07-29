package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferRequest {
    private final Integer accountFrom;
    private final Integer accountTo;
    private final Long amount;

}


