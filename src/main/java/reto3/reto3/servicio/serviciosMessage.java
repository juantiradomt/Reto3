package reto3.reto3.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.reto3.modelo.Message;
import reto3.reto3.repositorio.MessageRepositorio;

import java.util.Optional;
import java.util.List;

@Service
public class serviciosMessage {
    @Autowired
    private MessageRepositorio metodosCrud;

    public List<Message> getAll(){
        return metodosCrud.getAll();
    
    }

    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evt=metodosCrud.getMessage(message.getIdMessage());
            if(!evt.isEmpty()){
                if(message.getMessageText()!=null){
                    evt.get().setMessageText(message.getMessageText());
                }
                if(message.getBike()!=null){
                    evt.get().setBike(message.getBike());
                }
                if(message.getClient()!=null){
                    evt.get().setClient(message.getClient());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }
        }
        
        return message;
    }

    public boolean deleteMessage(int idMessage){
        Boolean datoboleano = getMessage(idMessage).map(message ->{
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return datoboleano;
    }
}
