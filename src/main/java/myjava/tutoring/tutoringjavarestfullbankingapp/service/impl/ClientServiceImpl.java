package myjava.tutoring.tutoringjavarestfullbankingapp.service.impl;

import lombok.AllArgsConstructor;
import myjava.tutoring.tutoringjavarestfullbankingapp.DAO.ClientDAO;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientAddRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientDTO;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientUpdateRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.util.Utils;
import org.springframework.stereotype.Service;

import myjava.tutoring.tutoringjavarestfullbankingapp.model.Client;
import myjava.tutoring.tutoringjavarestfullbankingapp.service.ClientService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDAO clientDAO;

    @Override
    public ClientDTO addClient(ClientAddRequest request) {
        if (Utils.optionalIsPresent(request)) {
            Client client = addRequestToClient(request);
            Client savedClient = clientDAO.save(client);
            return clientToDTO(savedClient);
        } else {
            throw new IllegalArgumentException("add client request is null!");
        }

    }

    @Override
    public ClientDTO updateClient(ClientUpdateRequest request) {
        if (Utils.optionalIsPresent(request)) {
            Client client = clientDAO.findClientByAccountNumber(request.getAccountNumber());
            client.setName(request.getName());
            clientDAO.save(client);
            return clientToDTO(client);
        } else {
            throw new IllegalArgumentException("update client request is null!");
        }

    }

    @Override
    public ClientDTO getClientByAccountNumber(Integer accountNumber) {
        return clientDAO.findById(accountNumber).map(this::clientToDTO).orElseThrow(() -> new IllegalArgumentException("no client with such account number in the database"));
    }

    @Override
    public void deleteClient(Integer accountNumber) {
        try {
            Client client = clientDAO.findClientByAccountNumber(accountNumber);
            if (Utils.optionalIsPresent(client)) {
                try {
                    clientDAO.delete(client);
                } catch (NoSuchElementException e) {
                    throw new IllegalArgumentException("no such client in the database!");
                }
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("no client with such account number in the database");
        }
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientDAO.findAll().stream().map(this::clientToDTO).collect(Collectors.toList());
    }

    private Client addRequestToClient(ClientAddRequest request) {
        return new Client(request.getName(), 0L);
    }

    private Client updateRequestToClient(ClientUpdateRequest request) {
        return new Client(request.getAccountNumber(),request.getName(), 0L);
    }

    private ClientDTO clientToDTO(Client client) {
        return new ClientDTO(client.getAccountNumber(), client.getName(), client.getAccountBalance());
    }
}
