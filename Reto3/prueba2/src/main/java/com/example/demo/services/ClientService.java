/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

import com.example.demo.models.ClientModel;
import com.example.demo.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS RYZEN
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAll() {
        return clientRepository.getAll();
    }

    public ClientModel save(ClientModel clientModel) {

        if (clientModel.getId() == null) {
            return clientRepository.save(clientModel);
        }

        Optional<ClientModel> clientdb = clientRepository.getClientById(clientModel.getId());

        if (clientdb.isEmpty()) {
            return clientRepository.save(clientModel);
        }

        return null;
    }

    public ClientModel getClientById(Integer id) {
        Optional<ClientModel> result = clientRepository.getClientById(id);

        if (result.isEmpty()) {
            return null;
        }

        return result.get();
    }

}
