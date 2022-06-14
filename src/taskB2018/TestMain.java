package taskB2018;

import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    protected String name;
    protected String afm;
    protected String iban;

    public Employee() {
    }

    public Employee(String name, String afm, String iban) {
        this.name = name;
        this.afm = afm;
        this.iban = iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getAfm() {
        return afm;
    }
    public void setAfm(String afm) {
        this.afm = afm;
    }

    // Η getEmployeeDescription θα υλοποιηθεί από τις κλάσεις που θα κληρονομήσουν αυτήν τηνκλάση
    public abstract String getEmployeeDescription();
}

class AnalystDesigner extends Employee {
    public AnalystDesigner(String name, String afm, String iban) {
        super(name, afm, iban);
    }

    @Override
    public String getEmployeeDescription() {
        return "Αναλυτής/Σχεδιαστής";
    }
}

class Programmer extends Employee {
    public Programmer(String name, String afm, String iban){
        super(name, afm, iban);
    }

    @Override
    public String getEmployeeDescription() {
        return "Προγραμματιστής";
    }
}

public class TestMain {
    public static List<Programmer> extractProgrammers(List<Employee> employees) {
        List<Programmer> programmers = new ArrayList<>();

        for (Employee e : employees) {
            if (e instanceof Programmer) {
                programmers.add((Programmer) e);
            }
        }

        return programmers;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Programmer("Yiannis", "324332", "453653"));
        employees.add(new AnalystDesigner("Giorgos", "53465", "65436"));
        employees.add(new AnalystDesigner("Kostas", "53465", "65436"));
        employees.add(new Programmer("Christos", "53465", "65436"));

        List<Programmer> programmers;

        programmers = extractProgrammers(employees);

        for (Programmer p : programmers) {
            System.out.println(p.getName() + " -> " + p.getEmployeeDescription());
        }

    }
}
