package col.com.proyecto.api.repositories;

import col.com.proyecto.api.models.Person;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author weizm
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    public abstract ArrayList<Person> findByApellido(String apellido);
}
