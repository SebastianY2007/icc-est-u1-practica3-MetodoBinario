package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public View(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public Scanner getScanner() {
        return this.scanner;
    }

    public int showMenu(){
        System.out.println("-".repeat(10) + " MENU " + "-".repeat(10));
        System.out.println("1. Añadir persona");
        System.out.println("2. Ordenar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Mostrar Personas");
        System.out.println("5. Salir");
        System.out.println("-".repeat(25));
        System.out.print("Ingrese una opcion: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public Person inputPerson(){
        System.out.print("Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(name, age);
        return person;
    }

    public int selectSortingMethod(){
        System.out.println("-".repeat(5) + " Metodo de ordenamiento " + "-".repeat(5));
        System.out.println("1. Por Nombre");
        System.out.println("2. Por Edad");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opcion: ");
        int option = scanner.nextInt();
        return option;
    }

    public int selectSearchCriterion(){
        System.out.println("-".repeat(5) + " Criterio de busqueda " + "-".repeat(5));
        System.out.println("1. Por Nombre");
        System.out.println("2. Por Edad");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opcion: ");
        int option = scanner.nextInt();
        return option;
    }
    public void displayPersons(Person[] persons){
        if (persons.length == 0){
            System.out.println("No hay personas en la lista");
        }else{
            for (Person person : persons){
                System.out.println(person);
            }
        }
    }

    public void displaySearchResult(Person person){
        if (person != null){
            System.out.println("Persona encontrada: " + person);
        }else{
            System.out.println("Persona no encontrada.");
        }
    }

    public int inputAge(){
        System.out.println("Ingrese la edad: ");
        int age = scanner.nextInt();
        return age; 
    }

    public String inputName(){
        System.out.println("Ingrese el nombre: ");
        String name = scanner.nextLine();
        return name;
    }
}