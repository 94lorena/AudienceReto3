/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto.audience.interfaces;

import com.reto.audience.entity.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LORENA NAVAS
 */
public interface RerservaInterface extends CrudRepository<Reserva,Integer> {

    public List<Reserva> findAllByStatus(String status);
    
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // select clientId, count(*) as "total" from reserva group by cliendId order by total desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
     
}
