package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Integer accountNumber;
    private String name;
    private Long accountBalance;
}
