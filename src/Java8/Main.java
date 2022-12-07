package Java8;

import Java8.Clases.Car;
import Java8.Clases.Person;
import Java8.Enums.Colour;
import Java8.Enums.Country;
import Java8.Enums.Gender;
import Java8.Service.impl.CarServiceImpl;
import Java8.Service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

        Car car1= new Car("Honda","Accord",new BigDecimal(5000), Year.of(2005),Colour.BLACK,Country.JAPAN);
        Car car2= new Car("Mersedes","124",new BigDecimal(4000),Year.of(2002),Colour.BLUE,Country.GERMANY);
        Car car3= new Car("Toyota","Windom",new BigDecimal(4500),Year.of(2003),Colour.RED,Country.KYRGYZSTAN);
        Car car4= new Car("Kia","Rio",new BigDecimal(5500),Year.of(2005),Colour.WHITE,Country.USA);
        Car car5= new Car("Audi","C4",new BigDecimal(3500),Year.of(2008),Colour.YELLOW,Country.KYRGYZSTAN);

        List<Car> cars= new ArrayList<>(List.of(car1,car2,car3,car4,car5));


        Person person1= new Person("Aktan",LocalDate.of(2002,10,14), Gender.MALE,new BigDecimal(500000),"5000532",List.of());
        Person person2= new Person("Akylai",LocalDate.of(2002,10,14), Gender.FEMALE,new BigDecimal(500000),"5990532",List.of());
        Person person3= new Person("Asan",LocalDate.of(2004,10,14), Gender.MALE,new BigDecimal(500000),"5010532",List.of());
        Person person4= new Person("Uson",LocalDate.of(2001,10,14), Gender.MALE,new BigDecimal(400000),"5022532",List.of());
        Person person5= new Person("Aman",LocalDate.of(2000,10,14), Gender.MALE,new BigDecimal(300000),"5800532",List.of());

         List<Person> people= new ArrayList<>(List.of(person1,person2,person3,person4,person5));

//         CarServiceImpl carService= new CarServiceImpl();
//        PersonServiceImpl personService= new PersonServiceImpl();
//        System.out.println(personService.createPerson(people));
//
//        System.out.println(personService.sortPersonDateOfBirth(people));
        PersonServiceImpl personService = new PersonServiceImpl();
        personService.createPerson(people);
        CarServiceImpl carService = new CarServiceImpl();
        carService.createCar(cars);
        while (true) {
            System.out.println("""
                        1 GET PERSON!
                        2 REMOVE PERSON!
                        2 FIND BY NAME!
                        4 FIND BY CARE NAME! 
                        5 PAY CARS!
                        6 SORT PERSON DATE OF BORDS!
                        7 SORT PERSON NAME!
                        8 SORT GENDER!
                        9 GET AGE!
                        10 REMOVE CAR!
                        11 GET ALL CAR!
                        12 FIND BY COUNTRY!""");
            System.out.println("san beriniz:");
            Scanner scanner=new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println(personService.getAll());
                    break;
                case 2:
                    String word = scanner.nextLine();
                    System.out.print("REMOVE PERSON : ");
                    System.out.println(personService.removePerson(scanner.nextLine(), people));
                    System.out.println(personService.getAll());
                    break;
                case 3:
                    String word1 = scanner.nextLine();
                    System.out.print("FIND BY NAME : ");
                    String word2 = scanner.nextLine();
                    System.out.println(personService.findByName(word2, people));
                    break;
                case 4:
                    String word4 = scanner.nextLine();
                    System.out.print("FIND BY CAR NAME : ");
                    System.out.println(personService.findByCarName(scanner.nextLine(), people));
                    break;
                case 5:
                    String word5 = scanner.nextLine();
                    System.out.print("PERSON NAME : ");
                    String name1 = scanner.next();
                    while (true) {

                        System.out.print("CAR NAME : ");
                        String carName1 = scanner.nextLine();
                        System.out.println(personService.payCars(name1, people, carName1, cars));
                        if ((personService.payCars(name1, people, carName1, cars) == ("You don't have enough money!!!"))) {
                            break;
                        }
                    }
                    break;


                case 6:
                    System.out.println("PRESS 1 = 1-2");
                    System.out.println("PRESS 2 = 2-1");
                    System.out.print("PRESS : ");
                    System.out.println(personService.sortPersonDateOfBirth(scanner.nextInt(), people));
                    break;
                case 7:
                    System.out.println("PRESS 1 = A-Я");
                    System.out.println("PRESS 2 = Я-А");
                    System.out.print("PRESS : ");
                    System.out.println(personService.sortPersonName(scanner.nextInt(), people));
                    break;
                case 8:
                    System.out.println("PRESS 1 = M-F");
                    System.out.println("PRESS 2 = F-M");
                    System.out.print("PRESS : ");
                    System.out.println(personService.sortGender(scanner.nextInt(), people));
                    break;
                case 9:
                    String name4 = scanner.nextLine();
                    System.out.print("PRESS PERSON NAME : ");
                    System.out.println(personService.getAge(scanner.nextLine(), people));
                    break;
                case 10:
                    String m = scanner.nextLine();
                    System.out.print("REMOVE CAR : ");
                    carService.removeCar(scanner.nextLine(), cars);
                    System.out.println(carService.getAll());
                    break;
                case 11:
                    System.out.println(carService.getAll());
                    break;
                case 12:
                    String na = scanner.nextLine();
                    System.out.print("FIND BY  COUNTRY : ");
                    System.out.println(carService.findByCountry(scanner.next(), cars));
                    break;
                default:
                    System.out.println("YOU ENTERED A WRONG COMBINATION!!!");
                    break;
            }
        }

    } catch (
    InputMismatchException e) {

        System.err.println("you entered a number instead of letters!!!");




    }
}
}