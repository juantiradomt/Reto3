package reto3.reto3.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto3.reto3.modelo.Category;
import reto3.reto3.repositorio.CategoryRepositorio;

import java.util.Optional;
import java.util.List;

@Service
public class serviciosCategory {
    @Autowired
    private CategoryRepositorio metodosCrud;

    public List<Category> getAll(){
        return metodosCrud.getAll();
    
    }

    public Optional<Category> getCategory(int idCategory){
        return metodosCrud.getCategory(idCategory);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Category> evt=metodosCrud.getCategory(category.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(category);
            }else{
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> evt=metodosCrud.getCategory(category.getId());
            if(!evt.isEmpty()){
                if(category.getName()!=null){
                    evt.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    evt.get().setDescription(category.getDescription());
                }
                if(category.getBike()!=null){
                    evt.get().setBike(category.getBike());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }
                
        }
        else{
         return category;
        }
        return category;
    }

    public boolean deleteCategory(int idCategory){
        Boolean datoboleano = getCategory(idCategory).map(category ->{
            metodosCrud.delete(category);
            return true;
        }).orElse(false);
        return datoboleano;
    }
}

