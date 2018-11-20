package lv.ctco.notepad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Person> records = new ArrayList<>();
    public static String ask = new String("What you would like to do: create, list, exit or delete?");

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println(ask);
            String cmd = scanner.next();
            switch (cmd) {
                case "c":
                    createPerson();
                    break;
//                case "help":
//                    showHelp();
//                    break;
                case "l":
                    list();
                    break;
                case "d":
                    delete();
                    break;
                case "e":
                    return;
                default:
                    System.out.println("Wrong command. Try 'help'");
            }
        }

    }

    private static void createPerson() {
        Person person = new Person();
        System.out.println("Please enter name");
        person.setFirsName(scanner.next());
        System.out.println("Please enter surname");
        person.setLastName(scanner.next());
        System.out.println("Please enter email");
        person.setEmail(scanner.next());
        System.out.println("Please enter phone number");
        person.setPhoneNumber(scanner.next());


        records.add(person);


    }

    private static void delete() {

        System.out.println("Please enter person's id you'd like to delete");
        list();
        int id = scanner.nextInt();
        int personId = records.indexOf() ;


        if (id == personId ) {
            records.remove(id);
        } else {
            System.out.println("id does not exist");


        }
    }

//    private static void loadPersons() {
//        try (Scanner in = new Scanner(Person)) {
//            while (in.hasNext()) {
//                Person person = new Person();
//                person.getId() = in.nextInt();
//
//                results.add(gr);
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

    private static void list() {
        records.forEach(r -> System.out.println(r));

    }
}
