package reto3.reto3.controlador;
import reto3.reto3.servicio.*;
import reto3.reto3.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Bike/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class Bikeweb {
    @Autowired
    private serviciosBike servicios;
    @GetMapping("/all")
    public List <Bike> getBike(){
        return servicios.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int idBike){
        return servicios.getBike(idBike);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike){
        return servicios.save(bike);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike){
        return servicios.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idBike){
        return servicios.deleteBike(idBike);
    }
}
