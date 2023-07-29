package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class TransactionRequest {
    private Integer accountNumber;
    private Long amount;

}
