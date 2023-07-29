package myjava.tutoring.tutoringjavarestfullbankingapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import myjava.tutoring.tutoringjavarestfullbankingapp.model.Client;

public interface ClientDAO extends JpaRepository<Client, Integer> {
    Client findClientByAccountNumber(Integer accountNumber);
}
