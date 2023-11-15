import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();
        int choice = 0;

        // Asking the user what he wants to do from the menu

        while (true){
            System.out.println("""
                    Expense Tracker Menu:
                    1. Add Expense
                    2. Load Expenses
                    3. Exit
                    Enter your choice:\s""");

            boolean input = false;
            while (!input) {

                try {
                     input = true;
                     choice = sc.nextInt();
                } catch (Exception e){
                    System.out.println("""
                                          Invalid choice. Plase select from the menu: 
                                          1. Add Expense
                                          2. Load Expenses
                                          3. Exit
                                          Enter your choice:\s""");
                    sc.next();
                    input = false;
                }
            }


            switch (choice){
                case 1:
                    System.out.println("Enter date: (DD/MM/YY): ");
                    String date = sc.next();
                    sc.nextLine();
                    System.out.println("Enter description: ");
                    String description = sc.nextLine();
                    System.out.println("Enter amount: ");
                    input = false;
                    while (!input){
                        try {
                            input = true;
                            double amount = sc.nextDouble();
                            expenses.add(new Expense(date, description, amount));
                            ExpenseStorage.saveExpense(expenses);
                        } catch (InputMismatchException e){
                            System.out.println("Please enter an amount: ");
                            sc.next();
                            input = false;
                        }
                    }
                    break;
                case 2:
                    for (Expense e: expenses){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Plase select from the menu.\n");
            }
        }


    }
}