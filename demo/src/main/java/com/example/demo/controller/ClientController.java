package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Client;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> cli = clientService.findAll();
        
        if (cli.isEmpty()) {
            ResponseEntity.noContent().build(); // Retorna 204 se a lista estiver vazia.
        }

        return ResponseEntity.ok().body(cli);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findByID(@PathVariable long id){
        Client cli = clientService.findByID(id);

        if (cli == null) {
            return ResponseEntity.notFound().build(); // Retorna o erro 404 se não for encontrado.
        }

        return ResponseEntity.ok().body(cli);
    }
}
