package Java8.Service.impl;

import Java8.Clases.Car;
import Java8.Clases.Person;
import Java8.Enums.Country;
import Java8.Service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService{
    private List<Car> cars = new ArrayList<>();


    @Override
    public String createCar(List<Car> cars) {
        this.cars.addAll(cars);
        return "WAS SUCCESSFUL!!!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if(car.getName().equals(name)){
                this.cars.remove(car);
            }
        }
        return "WAS SUCCESSFUL!!!";
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }


    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> people1 = new ArrayList<>();
        for (Person person : people) {
            if(person.getName().equals(name)){
                people1.add(person);
                return people1;
            }
        }
        return null;
    }

    @Override
    public List<Car> findByCountry(String name, List<Car> cars) {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCountryOfOrigin().name().equals(name.toUpperCase())){
                carList.add(car);

            }
        }
        return carList;
    }
}

