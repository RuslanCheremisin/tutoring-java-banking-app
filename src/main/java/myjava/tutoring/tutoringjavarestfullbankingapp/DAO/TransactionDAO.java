package myjava.tutoring.tutoringjavarestfullbankingapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import myjava.tutoring.tutoringjavarestfullbankingapp.model.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Integer> {
}
