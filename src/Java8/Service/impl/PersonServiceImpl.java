package Java8.Service.impl;

import Java8.Clases.Car;
import Java8.Clases.Person;
import Java8.Service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonServiceImpl implements PersonService , Comparator<PersonServiceImpl> {
    private List<Person> people = new ArrayList<>();


    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "succusffully save person";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            Person next = iterator.next();
            if (next.getName().equals(name)) {
                iterator.remove();
                return "succussful remove this person"+next.getName();
            }
        }
        return "Filed remove this person ";
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> names = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                names.add(person);
            }
        }
        return names;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> carNames=new ArrayList<>();
        for (Person person:people) {
            if(person.getCars().equals(carNames)){


                carNames.add(person);
            }
        }
        return  carNames;
    }

    @Override
    public String payCars(String name, List<Person> person, String carName, List<Car> cars) {
        for (Person person1 : this.people) {
            if(person1.getName().equals(name)){
                for (Car car : cars) {
                    if(car.getName().equals(carName)){
                        if(person1.getMoney().doubleValue() >= car.getPrice().doubleValue()) {
                            List<Car> carList = new ArrayList<>(person1.getCars());
                            carList.add(car);
                            person1.setCars(carList);
                            person1.setMoney(person1.getMoney().subtract(car.getPrice()));
                            cars.remove(car);
                            return "Car buy was SUCCESSFUL!";
                        } else return "Person's money is now enough to buy this car!";
                    }
                }
            }
        }
        return "Purchase failed";
    }


    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
        return null;
    }

    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        return null;
    }

    @Override
    public List<Person> sortGender(List<Person> person) {
        return null;
    }


    public Comparator<Person>sortPersonDateOfBirthsort1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };
    public Comparator<Person>sortPersonDateOfBirthsort2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getDateOfBirth().compareTo(o1.getDateOfBirth());
        }
    };

    @Override
    public List<Person> sortPersonDateOfBirth(int num, List<Person> persons) {
        List <Person> kk = new ArrayList<>();
        kk.addAll(persons);
        if (num==1){
            kk.sort(sortPersonDateOfBirthsort1);
        }else if (num==2){
            kk.sort(sortPersonDateOfBirthsort2);
        }
        return kk;
    }
    public Comparator<Person>sortPersonNamesort1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public Comparator<Person>sortPersonNamesort2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public List<Person> sortPersonName(int num, List<Person> persons) {
        List<Person>pp = new ArrayList<>();
        pp.addAll(persons);
        if (num==1){
            pp.sort(sortPersonNamesort1);
        }else if (num==2){
            pp.sort(sortPersonNamesort2);
        }
        return pp;
    }
    public Comparator<Person>personComparatorGender1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().compareTo(o2.getGender());
        }
    };
    public Comparator<Person>personComparatorGender2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getGender().compareTo(o1.getGender());
        }
    };

    @Override
    public List<Person> sortGender(int num, List<Person> person) {
        if(num==1){
            person.sort(personComparatorGender1);
        } else if (num==2) {
            person.sort(personComparatorGender2);
        }else {
            return null;
        }

        return person;
    }

    @Override
    public int getAge(String name, List<Person> person) {
        for (Person person1 : person) {
            if (person1.getName().equals(name)){
                int age = Period.between(person1.getDateOfBirth(), LocalDate.now()).getYears();
                return age;
            }
        }
        return 0;
    }

    @Override
    public int compare(PersonServiceImpl o1, PersonServiceImpl o2) {
        return 0;
    }
}

