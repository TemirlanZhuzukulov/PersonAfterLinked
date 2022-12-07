package Java8.Service;

import Java8.Clases.Car;
import Java8.Clases.Person;
import Java8.Clases.Person;

import java.util.List;

public interface PersonService {
    String createPerson(List<Person> people);

    String removePerson(String name, List<Person> people);


    List<Person> getAll();

    List<Person> findByName(String name, List<Person> people);

    List<Person> findByCarName(String name, List<Person> people);

    String payCars(String name, List<Person> person, String carName, List<Car> cars);

    List<Person>sortPersonDateOfBirth(List<Person>persons);

    List<Person>sortPersonName(List<Person>persons);

    List<Person>sortGender(List<Person>person);


    List<Person> sortPersonDateOfBirth(int num, List<Person> persons);

    List<Person> sortPersonName(int num, List<Person> persons);

    List<Person> sortGender(int num, List<Person> person);

    int getAge(String name, List<Person> person);
}
