import controllers.Controller;
import controllers.SearchMethods;
import controllers.SortingMethods;
import java.util.Scanner;
import views.View;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        View view = new View(scanner);
        SortingMethods sortingMethods = new SortingMethods(); 
        SearchMethods searchMethods = new SearchMethods();  
        
        Controller controller = new Controller(view, sortingMethods, searchMethods);
        
        controller.start();
    }
}