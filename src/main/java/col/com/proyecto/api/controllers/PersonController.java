package col.com.proyecto.api.controllers;

import col.com.proyecto.api.models.Person;
import col.com.proyecto.api.services.PersonService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author weizm
 */
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ArrayList<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    @PostMapping()
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/query")
    public ArrayList<Person> getPersonByApellido(@RequestParam("apellido") String apellido) {
        return personService.getPersonByApellido(apellido);
    }
    
    @DeleteMapping("/{id}")
    public String removePerson(@PathVariable("id") Long id){
        if (personService.removePerson(id)){
            return "Se eliminó la persona con el id " + id + " correctamente";
        } else {
            return "La persona con el id " + id + " no existe o no se encuentra registrada";
        }
    }
}
