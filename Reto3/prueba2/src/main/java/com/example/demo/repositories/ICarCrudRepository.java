/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositories;

import com.example.demo.models.CarModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ASUS RYZEN
 */
public interface ICarCrudRepository extends CrudRepository<CarModel, Integer>{
    
}
