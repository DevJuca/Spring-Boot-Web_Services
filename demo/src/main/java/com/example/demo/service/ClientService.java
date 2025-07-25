package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findByID(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.get();
    }

    public Client insert(Client obj){
        return clientRepository.save(obj);
    }
}
