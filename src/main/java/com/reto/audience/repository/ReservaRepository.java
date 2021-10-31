/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto.audience.repository;

/**
 *
 * @author LORENA NAVAS
 */

import com.reto.audience.entity.Cliente;
import com.reto.audience.entity.Reserva;
import com.reto.audience.interfaces.RerservaInterface;
import com.reto.audience.report.ClienteContador;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<Reserva> ReservaStatus (String status){
        return crud4.findAllByStatus(status);
    }
     
    public List<Reserva> ReservaTiempo (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
   
    public List<ClienteContador> getTopCliente(){
        List<ClienteContador> res=new ArrayList<>();
        List<Object[]>report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
             res.add(new ClienteContador((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         
        }
        return res;
     }    
}
