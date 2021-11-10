/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.models.ClientModel;
import com.example.demo.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS RYZEN
 */
@RestController
@RequestMapping("/api/Client")
public class HolaMundoController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<ClientModel> save(@RequestBody ClientModel clientModel) {
        ClientModel clientModelresponse = clientService.save(clientModel);

        if (clientModelresponse == null) {
            return new ResponseEntity(clientModelresponse, HttpStatus.CONFLICT);
        }

        return new ResponseEntity(clientModelresponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable Integer id) {

        ClientModel result = clientService.getClientById(id);

        if (result == null) 
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    //@PutMapping
    
    //@DeleteMapping
    
    
    

}
