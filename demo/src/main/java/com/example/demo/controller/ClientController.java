package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    // Inserindo
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client cli){
        cli = clientService.insert(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();

        return ResponseEntity.created(uri).body(cli);
    }

    // Deletando
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizando
    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client cli){
        cli = clientService.update(id, cli);
        return ResponseEntity.ok().body(cli);
    }
}
