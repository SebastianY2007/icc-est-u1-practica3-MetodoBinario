package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private List<Person> persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new ArrayList<>();
    }

    public void start(){
        boolean opc = true;
        while (opc) {
            int option = view.showMenu();
            
            switch (option) {
                case 1:
                    addPersons();
                    break;
                case 2:
                    sortPersons();
                    break;
                case 3:
                    searchPerson();
                    break;
                case 4:              
                    view.displayPersons(persons.toArray(new Person[0]));
                    break;
                case 5:
                    opc = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    public void inputPersons(){
        boolean adding = true;
        while (adding) {
            Person person = view.inputPerson();
            persons.add(person); 
            System.out.println("\nPersona añadida: " + person);

            System.out.print("¿Desea añadir otra persona? (sí/no): ");
            String respuesta = view.getScanner().nextLine();
            if (!respuesta.equalsIgnoreCase("sí")) {
                adding = false;  
                System.out.println("Finalizando adición de personas.");
            }
        }
    }

    public void addPersons(){
        Person person = view.inputPerson(); 
        persons.add(person);
        System.out.println("Persona añadida: " + person);
    }

    public void sortPersons(){
        int sortingMethod = view.selectSortingMethod();

        switch (sortingMethod) {
            case 1:
                sortingMethods.sortByNameWithBubble(persons.toArray(new Person[0]));
                System.out.println("Personas ordenadas por nombre.");
                break;
            case 2:
                sortingMethods.sortByAgeWithInsertion(persons.toArray(new Person[0]));
                System.out.println("Personas ordenadas por edad.");
                break;
            case 3:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }

    public void searchPerson(){
        int searchCriterion = view.selectSearchCriterion();

        switch (searchCriterion) {
            case 1: 
                String name = view.inputName();
                Person foundByName = searchMethods.binarySearchByName(persons.toArray(new Person[0]), name);
                view.displaySearchResult(foundByName);
                break;
            case 2: 
                int age = view.inputAge();
                Person foundByAge = searchMethods.binarySearchByAge(persons.toArray(new Person[0]), age);
                view.displaySearchResult(foundByAge);
                break;
            case 3:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
