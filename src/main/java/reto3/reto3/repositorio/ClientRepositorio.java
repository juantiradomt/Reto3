package reto3.reto3.repositorio;
import reto3.reto3.operaciones.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositorio {
    @Autowired
    private operacionesClient crud;

    public List<Client> getAll(){
        return (List<Client>) crud.findAll();

    }
    public Optional <Client> getClient(int id){
        return crud.findById(id);
    }

    public Client save(Client client){
        return crud.save(client);
    }

    public void delete(Client client){
        crud.delete(client);
    }
}
