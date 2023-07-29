package myjava.tutoring.tutoringjavarestfullbankingapp.service;

import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientAddRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientDTO;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientUpdateRequest;

import java.util.List;

public interface ClientService {

    ClientDTO addClient(ClientAddRequest dto);

    ClientDTO updateClient(ClientUpdateRequest request);

    ClientDTO getClientByAccountNumber(Integer accountNumber);

    void deleteClient(Integer accountNumber);

    List<ClientDTO> getAllClients();



}
