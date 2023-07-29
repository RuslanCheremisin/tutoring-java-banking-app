package myjava.tutoring.tutoringjavarestfullbankingapp.service;


import myjava.tutoring.tutoringjavarestfullbankingapp.dto.*;
import org.springframework.stereotype.Service;


@Service
public interface TransactionService {

    TransactionDTO doDeposit(DepositRequest request);

    TransactionDTO doWithdrawal(WithdrawalRequest request);

    TransferDTO doTransfer(TransferRequest request);

}
