package se.ecutb.hala.mvc_excersice_thymeleaf.data;

import org.springframework.stereotype.Component;
import se.ecutb.hala.mvc_excersice_thymeleaf.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDaoImpl implements PersonDao {

    private List<Person> people = new ArrayList<>();

    @Override
    public Optional<Person> findById(int id){
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
    }

    @Override
    public Optional<Person> findByEmail(String email){
        return people.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean save(Person person){
        return people.add(person);
    }

    @Override
    public Person update(Person person){
        Person original = findById(person.getId()).get();
        original.setBirthDate(person.getBirthDate());
        original.setEmail(person.getEmail());
        original.setName(person.getName());
        original.setGender(person.getGender());
        return original;
    }

    @Override
    public boolean delete(int id){
        Person person = findById(id).get();
        return people.remove(person);
    }

    @Override
    public List<Person> findAll(){
        return people;
    }
}
