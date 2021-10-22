package reto3.reto3.repositorio;
import reto3.reto3.operaciones.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositorio {
    
    @Autowired
    private operacionesReservation crud;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();

    }
    public Optional <Reservation> getReservation(int id){
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
}
