import java.io.*;
import java.util.ArrayList;

public class ExpenseStorage {
    // We create the ExpenseStorage object which will manage the information of the expenses, we can save
    // or load the expenses
    private static final String FILENAME = "expenses.txt";

    public static void saveExpense(ArrayList<Expense> expenses){
        try (PrintWriter writer = new PrintWriter(FILENAME)){
            for (Expense e : expenses)
            writer.println(e.getDate() + ", " + e.getDescription() + ", " + e.getAmount());
        } catch (IOException e){
            System.out.println("Error saving the expenses: " + e.getMessage());
        }
    }

    public static ArrayList<Expense> loadExpenses(){
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
            String line;
            while ((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                expenses.add(new Expense(parts[0], parts[1],Double.parseDouble(parts[2])));
            }
        } catch (IOException e){
            System.out.println("Error loading the expenses: " + e.getMessage());
        }

        return expenses;
    }


}
