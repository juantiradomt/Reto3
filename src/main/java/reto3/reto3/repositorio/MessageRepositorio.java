package reto3.reto3.repositorio;
import reto3.reto3.operaciones.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepositorio {
    
    @Autowired
    private operacionesMessage crud;

    public List<Message> getAll(){
        return (List<Message>) crud.findAll();

    }
    public Optional <Message> getMessage(int id){
        return crud.findById(id);
    }

    public Message save(Message message){
        return crud.save(message);
    }

    public void delete(Message message){
        crud.delete(message);
    }
}
