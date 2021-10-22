package reto3.reto3.operaciones;

import org.springframework.data.repository.CrudRepository;

import reto3.reto3.modelo.Client;

public interface operacionesClient extends CrudRepository<Client,Integer> {
    
}
