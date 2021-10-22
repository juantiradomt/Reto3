package reto3.reto3.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import reto3.reto3.modelo.*;
import reto3.reto3.repositorio.BikeRepositorio;

import java.util.Optional;
import java.util.List;

@Service
public class serviciosBike {
    @Autowired
    private BikeRepositorio metodosCrud;

    public List<Bike> getAll(){
        return metodosCrud.getAll();
    
    }

    public Optional<Bike> getBike(int idBike){
        return metodosCrud.getBike(idBike);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Bike> evt=metodosCrud.getBike(bike.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> evt=metodosCrud.getBike(bike.getId());
            if(!evt.isEmpty()){
                if(bike.getName()!=null){
                    evt.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    evt.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    evt.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    evt.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    evt.get().setCategory(bike.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }
                
        }
        return bike;
       
        
    }

    public boolean deleteBike(int idBike){
        Boolean datoboleano = getBike(idBike).map(bike ->{
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return datoboleano;
    }
}
