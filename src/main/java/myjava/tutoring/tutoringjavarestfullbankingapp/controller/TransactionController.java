package myjava.tutoring.tutoringjavarestfullbankingapp.controller;

import myjava.tutoring.tutoringjavarestfullbankingapp.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myjava.tutoring.tutoringjavarestfullbankingapp.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> doDeposit(DepositRequest request) {
        return ResponseEntity.ok(transactionService.doDeposit(request));
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<TransactionDTO> doWithdrawal(WithdrawalRequest request) {
        return ResponseEntity.ok(transactionService.doWithdrawal(request));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferDTO> doTransfer(TransferRequest request) {
        return ResponseEntity.ok(transactionService.doTransfer(request));
    }
}
