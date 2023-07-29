package myjava.tutoring.tutoringjavarestfullbankingapp.service.impl;

import lombok.AllArgsConstructor;
import myjava.tutoring.tutoringjavarestfullbankingapp.DAO.ClientDAO;
import myjava.tutoring.tutoringjavarestfullbankingapp.DAO.TransactionDAO;
import myjava.tutoring.tutoringjavarestfullbankingapp.util.Utils;

import java.time.LocalDateTime;

import myjava.tutoring.tutoringjavarestfullbankingapp.dto.DepositRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.TransactionDTO;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.TransferRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.WithdrawalRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.model.Client;
import myjava.tutoring.tutoringjavarestfullbankingapp.model.Transaction;
import myjava.tutoring.tutoringjavarestfullbankingapp.model.TransactionType;
import myjava.tutoring.tutoringjavarestfullbankingapp.service.TransactionService;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.TransferDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionDAO transactionDAO;
    private final ClientDAO clientDAO;

    @Override
    public TransactionDTO doDeposit(DepositRequest request) {
        Client client = clientDAO.findClientByAccountNumber(request.getAccountNumber());
        client.setAccountBalance(client.getAccountBalance() + request.getAmount());
        clientDAO.save(client);
        return transactionToDTO(transactionDAO.save(depositRequestToTransaction(request)));
    }

    @Override
    public TransactionDTO doWithdrawal(WithdrawalRequest request) {
        Client client = clientDAO.findClientByAccountNumber(request.getAccountNumber());
        client.setAccountBalance(client.getAccountBalance() - request.getAmount());
        clientDAO.save(client);
        return transactionToDTO(transactionDAO.save(withdrawalRequestToTransaction(request)));
    }
    @Override
    public TransferDTO doTransfer(TransferRequest request) {
        if (Utils.optionalIsPresent(request)) {
            doWithdrawal(new WithdrawalRequest(request.getAccountFrom(), request.getAmount()));
            doDeposit(new DepositRequest(request.getAccountTo(), request.getAmount()));
        }
        return new TransferDTO(request.getAccountFrom(), request.getAccountFrom(), request.getAmount(), LocalDateTime.now().getNano());
    }

    private Transaction depositRequestToTransaction(DepositRequest request) {
        return new Transaction(
                clientDAO.findClientByAccountNumber(
                        request.getAccountNumber()),
                TransactionType.DEPOSIT,
                request.getAmount(),
                LocalDateTime.now().getNano());
    }

    private Transaction withdrawalRequestToTransaction(WithdrawalRequest request) {
        return new Transaction(
                clientDAO.findClientByAccountNumber(
                        request.getAccountNumber()),
                TransactionType.WITHDRAWAL,
                request.getAmount(),
                LocalDateTime.now().getNano());
    }

    private TransactionDTO transactionToDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getClient().getAccountNumber(),
                transaction.getType(),
                transaction.getTransactionAmount(),
                transaction.getDateTime());
    }
}
