package Enrico.Zagallo.SpringTest.Repository;

import Enrico.Zagallo.SpringTest.Domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findByName(String name);
}
