package Enrico.Zagallo.SpringTest.Repository;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

}
