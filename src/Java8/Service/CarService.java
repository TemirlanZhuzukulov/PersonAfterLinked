package Java8.Service;


import Java8.Clases.Car;
import Java8.Clases.Person;
import Java8.Enums.Country;


import java.util.List;

public interface CarService  {
    String createCar(List<Car>cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll();

    List<Person>findByName(String name,List<Person>people);

    List<Car>findByCountry(String name, List<Car> persons);
}

