import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/12/15.
 */
public class ToDo {
    static void printTodos(ArrayList<ToDoItem> todos) {
        int todoNum = 1; //numbering the todos
        for (ToDoItem todo : todos) { // if we need to loop over every item in a collection like an arraylist use the for loop
            String checkBox = "[ ]";
            if (todo.isDone) {
                checkBox = "[x]";
            }
            String line = String.format("%d. %s %s", todoNum, checkBox, todo.text); //static because it's in the class calling the Strings, if it wasn't we could call it on a particular string like CheckBox.
            System.out.println(line);
            todoNum++; //adding one each time. 1, 2, 3, etc.
        }
    }
    public static void main(String[] args) {
        ArrayList<ToDoItem> todos = new ArrayList<>(); //the angle brackets can be removed from the second instance of ArrayList
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printTodos(todos);//infinite loop

            System.out.println("Options:");
            System.out.println("[1] Create todo");
            System.out.println("[2] Mark todo as done or not done"); //checks or unchecks done box

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("Type a todo and hit enter.");
                String todo = scanner.nextLine();
                ToDoItem item = new ToDoItem(todo);
                todos.add(item); //adding the information entered (string t o d o), allowed from the line above, to the ArrayList called todos

            } else if (optionNum == 2) {
                System.out.println("Type the number of the todo you would like to toggle.");
                String select = scanner.nextLine();
                try { //catch all exceptions, i.e. putting the number 3 to mark done when you only have 2 todos.
                    int selectNum = Integer.valueOf(select); //convert string (select) to int (selectNum)
                    ToDoItem item = todos.get(selectNum - 1); //pull out item from arraylist; we have to subtract by one because we start at 1 but it starts at 0
                    item.isDone = !item.isDone; //changing done from false (which is set in ToDoItem class) to true, OR if item is true, it will set it back to false.
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                }
            } else { //catches numerical errors outside of option 2
                System.out.println("Invalid number.");
            }
        }
    }
}
