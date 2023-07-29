package myjava.tutoring.tutoringjavarestfullbankingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Client client;
    private TransactionType type;
    private Long transactionAmount;
    private Integer dateTime;

    public Transaction(Client client, TransactionType type, Long transactionAmount, Integer dateTime) {
        this.client = client;
        this.type = type;
        this.transactionAmount = transactionAmount;
        this.dateTime = dateTime;
    }

}
