package myjava.tutoring.tutoringjavarestfullbankingapp.controller;

import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientAddRequest;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientDTO;
import myjava.tutoring.tutoringjavarestfullbankingapp.dto.ClientUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import myjava.tutoring.tutoringjavarestfullbankingapp.service.ClientService;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(ClientAddRequest client){
        return ResponseEntity.ok(clientService.addClient(client));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(ClientUpdateRequest client){
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @GetMapping
    public ResponseEntity<ClientDTO> getClient(Integer accountNumber){
        return ResponseEntity.ok(clientService.getClientByAccountNumber(accountNumber));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @DeleteMapping
    public ResponseEntity<?> removeClient(Integer accountNumber){
        clientService.deleteClient(accountNumber);
        return ResponseEntity.noContent().build();
    }
}
