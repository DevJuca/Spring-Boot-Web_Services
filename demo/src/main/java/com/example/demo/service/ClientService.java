package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findByID(Long id){
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    public Client insert(Client obj){
        return clientRepository.save(obj);
    }

    public void delete(Long id){
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
        
    }

    public Client update(Long id, Client obj){
        try {
            Client entity = clientRepository.getReferenceById(id);
            updateData(entity, obj);
            return clientRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateData(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
