// Άσκηση 2, Τελικές 2020

package Expense;

import java.util.ArrayList;

interface Expense {
    double getValue();
    String getCategory();
    void setCategory(String category);
}

class GeneralConsuption implements Expense {
    private double value;
    private String category;

    public GeneralConsuption(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Κατηγορία εξόδου: " + category + "\n"
                + "Αξία εξόδου: " + value + "\n";
    }
}

class Utilities implements Expense {
    private double value;
    private String category;

    public Utilities(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Κατηγορία εξόδου: " + category + "\n"
                + "Αξία εξόδου: " + value + "\n";
    }
}

class Expenses {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();

        Expense expense1 = new GeneralConsuption(400.0);
        expense1.setCategory("Σούπερ Μάρκετ");
        Expense expense2 = new Utilities(100.0);
        expense2.setCategory("Παροχή Ηλεκτρικής Ενέργειας");

        expenses.add(expense1);
        expenses.add(expense2);

        double sum = 0;

        for (Expense e : expenses) {
            System.out.println(e);
            sum += e.getValue();
        }

        System.out.println("Συνολική αξία εξόδων: " + sum);

    }
}