public class Expense {
    // Creating the object Expense which will contain date, a description and an amount
    // Then we create the constructor which must recive a date, desc and amount and the getters
    private String date;
    private String description;
    private double amount;

    public Expense(String date, String description, double amount){
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Expense{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
