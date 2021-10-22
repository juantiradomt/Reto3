package reto3.reto3.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.reto3.modelo.*;
import reto3.reto3.repositorio.*;

import java.util.Optional;
import java.util.List;

@Service
public class serviciosReservation {
    @Autowired
    private ReservationRepositorio metodosCrud;

    public List<Reservation> getAll(){
        return metodosCrud.getAll();
    
    }

    public Optional<Reservation> getReservation(int idReservation){
        return metodosCrud.getReservation(idReservation);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(evt.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> evt=metodosCrud.getReservation(reservation.getIdReservation());
            if(!evt.isEmpty()){
                if(reservation.getStarDate()!=null){
                    evt.get().setStarDate(reservation.getStarDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    evt.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    evt.get().setStatus(reservation.getStatus());
                }
                if(reservation.getScore()!=null){
                    evt.get().setScore(reservation.getScore());
                }
                if(reservation.getClient()!=null){
                    evt.get().setClient(reservation.getClient());
                }
                if(reservation.getBike()!=null){
                    evt.get().setBike(reservation.getBike());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }
        }
        else{
         return reservation;
        }
        return reservation;
    }

    public boolean deleteReservation(int idReservation){
        Boolean datoboleano = getReservation(idReservation).map(reservation ->{
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return datoboleano;
    }
    
}
