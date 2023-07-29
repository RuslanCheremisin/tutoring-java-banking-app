package myjava.tutoring.tutoringjavarestfullbankingapp.dto;

public class DepositRequest extends TransactionRequest {
    public DepositRequest(Integer accountNumber, Long amount) {
        super(accountNumber, amount);
    }
}
