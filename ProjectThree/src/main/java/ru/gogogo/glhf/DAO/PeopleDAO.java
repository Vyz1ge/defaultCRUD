package ru.gogogo.glhf.DAO;

import org.springframework.stereotype.Component;
import ru.gogogo.glhf.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PeopleDAO {
    private List<Person> people;
    private int  COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person("Mike",++COUNT));
        people.add(new Person("Bob",++COUNT));
        people.add(new Person("Tom",++COUNT));
        people.add(new Person("John",++COUNT));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        for (Person x: people){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }

    public void save(Person person){
        person.setId(++COUNT);
        people.add(person);
    }


    public void edit(Person person,int id){
        Person personupdating = show(id);
        personupdating.setName(person.getName());
    }

    public void delete(int id){
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                people.remove(i);
                break;
            }
        }

    }
}
