import java.util.ArrayList;

class TeachingClass implements Expense{
    private String descr;
    private double surface;
    private double consuption;

    public TeachingClass(String descr, double surface, double consuption) {
        this.descr = descr;
        this.surface = surface;
        this.consuption = consuption;
    }

    @Override
    public double calcMohtlyExpense() {
        return surface * consuption;
    }
}

class Employee implements Expense {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcMohtlyExpense() {
        return salary;
    }
}

interface Expense {
    double calcMohtlyExpense();
}

public class School {
    static double calcExpenses(ArrayList<Expense> e) {
        double sum = 0;

        for(Expense expense : e) {
            sum += expense.calcMohtlyExpense();
        }

        return sum;
    }

    static double calcAvgEmployeeExp(ArrayList<Expense> e) {
        double sum = 0;
        int count = 0;

        for(Expense expense : e) {
            if(expense instanceof Employee) {
                sum += expense.calcMohtlyExpense();
                count++;
            }
        }

        return sum / count;
    }

    public static void main(String[] args) {
        ArrayList<Expense> expensesList = new ArrayList<>();

        expensesList.add(new TeachingClass("A", 23, 13));
        expensesList.add(new TeachingClass("B", 29, 15));
        expensesList.add(new Employee("Nikos", 800));
        expensesList.add(new Employee("Yiannis", 560));

        System.out.println("Μηνιαία έξοδα: " + calcExpenses(expensesList));
        System.out.println("Μέσοι μισθοί εργαζομένων: " + calcAvgEmployeeExp(expensesList));
    }
}
