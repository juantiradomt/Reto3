package reto3.reto3.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.reto3.modelo.Client;
import reto3.reto3.repositorio.ClientRepositorio;

import java.util.Optional;
import java.util.List;

@Service
public class serviciosClient {
    @Autowired
    private ClientRepositorio metodosCrud;

    public List<Client> getAll(){
        return metodosCrud.getAll();
    
    }

    public Optional<Client> getClient(int idClient){
        return metodosCrud.getClient(idClient);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evt=metodosCrud.getClient(client.getIdClient());
            if(!evt.isEmpty()){
                if(client.getName()!=null){
                    evt.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    evt.get().setEmail(client.getEmail());
                }
                if(client.getAge()!=null){
                    evt.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evt.get().setPassword(client.getPassword());
                }
                if(client.getMessage()!=null){
                    evt.get().setMessage(client.getMessage());
                }
                if(client.getReservation()!=null){
                    evt.get().setReservation(client.getReservation());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }
                
        }
        
        return client;
    }

    public boolean deleteClient(int idClient){
        Boolean datoboleano = getClient(idClient).map(client ->{
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return datoboleano;
    }
}
