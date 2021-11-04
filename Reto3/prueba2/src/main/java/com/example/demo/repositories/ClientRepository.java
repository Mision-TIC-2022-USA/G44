/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.models.ClientModel;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS RYZEN
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private IClientCrudRepository clientCrudRepository;
    
    public List<ClientModel> getAll()
    {
       return (List)clientCrudRepository.findAll();
    }
    
    public ClientModel save(ClientModel clientModel)
    {
       return clientCrudRepository.save(clientModel);
    }
    
    public Optional<ClientModel> getClientById(int id)
    {
       return clientCrudRepository.findById(id);
    }
}
