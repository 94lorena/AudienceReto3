/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto.audience.repository;

/**
 *
 * @author LORENA NAVAS
 */

import com.reto.audience.entity.Reserva;
import com.reto.audience.interfaces.RerservaInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReservaRepository {

@Autowired
    private RerservaInterface crud4;

    public List<Reserva> getAll(){
        return (List<Reserva>) crud4.findAll();
    }
    public Optional<Reserva> getReservation(int id){
        return crud4.findById(id);
    }
    public Reserva save(Reserva reservation){
        return crud4.save(reservation);
    }
    public void delete(Reserva reservation){
        crud4.delete(reservation);
    }
    
}
