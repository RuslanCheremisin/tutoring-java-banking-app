package myjava.tutoring.tutoringjavarestfullbankingapp.dto;



public class WithdrawalRequest extends TransactionRequest{
    public WithdrawalRequest(Integer accountNumber, Long amount) {
        super(accountNumber, amount);
    }
}
