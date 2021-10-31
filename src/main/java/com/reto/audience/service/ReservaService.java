/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto.audience.service;

/**
 *
 * @author LORENA NAVAS
 */

import com.reto.audience.entity.Reserva;
import com.reto.audience.report.ClienteContador;
import com.reto.audience.report.ReservaStatus;
import com.reto.audience.repository.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservaService {

 @Autowired
    private ReservaRepository metodosCrud;

    public List<Reserva> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reserva> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reserva save(Reserva reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reserva> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reserva update(Reserva reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reserva> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public ReservaStatus getReporteStatusReserva(){
        List<Reserva>completed= metodosCrud.ReservaStatus("completed");
        List<Reserva>cancelled= metodosCrud.ReservaStatus("cancelled");
        return new ReservaStatus(completed.size(), cancelled.size());
    }
    
    public List<Reserva> getReportesTiempoReserva(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservaTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }
    }  
    
    public List<ClienteContador> servicioTopCliente(){
        return metodosCrud.getTopCliente();
    }    
}
