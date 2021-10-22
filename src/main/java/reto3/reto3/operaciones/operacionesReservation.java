package reto3.reto3.operaciones;

import org.springframework.data.repository.CrudRepository;

import reto3.reto3.modelo.Reservation;

public interface operacionesReservation extends CrudRepository<Reservation, Integer>{
    
}
