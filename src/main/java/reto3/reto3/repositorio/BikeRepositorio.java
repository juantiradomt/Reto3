package reto3.reto3.repositorio;
import reto3.reto3.operaciones.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepositorio {
    
    @Autowired
    private operacionesBike crud;

    public List<Bike> getAll(){
        return (List<Bike>) crud.findAll();

    }
    public Optional <Bike> getBike(int id){
        return crud.findById(id);
    }

    public Bike save(Bike bike){
        return crud.save(bike);
    }

    public void delete(Bike bike){
        crud.delete(bike);
    }
}
