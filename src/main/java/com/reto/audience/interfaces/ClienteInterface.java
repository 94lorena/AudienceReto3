/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto.audience.interfaces;

import com.reto.audience.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LORENA NAVAS
 */
public interface ClienteInterface extends CrudRepository<Cliente,Integer> {
    
}
