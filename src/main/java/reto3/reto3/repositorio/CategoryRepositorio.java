package reto3.reto3.repositorio;
import reto3.reto3.operaciones.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositorio {
    @Autowired
    private operacionesCategory crud;

    public List<Category> getAll(){
        return (List<Category>) crud.findAll();

    }
    public Optional <Category> getCategory(int id){
        return crud.findById(id);
    }

    public Category save(Category category){
        return crud.save(category);
    }

    public void delete(Category category){
        crud.delete(category);
    }
}
