package se.ecutb.hala.mvc_excersice_thymeleaf.data;

import se.ecutb.hala.mvc_excersice_thymeleaf.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    Optional<Person> findById(int id);

    Optional<Person> findByEmail(String email);

    boolean save(Person person);

    Person update(Person person);

    boolean delete(int id);

    List<Person> findAll();
}
