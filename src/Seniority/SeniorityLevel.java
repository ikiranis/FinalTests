// Άσκηση 4, Επαναληπτικές 2020

package Seniority;

import java.util.ArrayList;

class Employee {
    enum SeniorityLevel {
        Junior, Mid, Senior
    }

    private final String name;
    private SeniorityLevel seniorityLevel;
    private Manager manager = null;

    public Employee(String name, SeniorityLevel seniorityLevel, Manager manager) {
        this.name = name;
        this.seniorityLevel = seniorityLevel;
        if (manager != null) {
            this.manager = manager;
            this.manager.addEmployeeToTeam(this);
        }
    }

    public String getName() {
        return name;
    }

    public SeniorityLevel getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
        this.manager.addEmployeeToTeam(this);
    }

    public ArrayList<Employee> getMyColleagues() {
        ArrayList<Employee> colleagues = new ArrayList<>();

        for (Employee employee : manager.getTeam()) {
            if (!employee.getName().equals(name)) {
                colleagues.add(employee);
            }
        }

        return colleagues;
    }
}

class Manager extends Employee {
    private final String departmentName;
    private final ArrayList<Employee> team;

    public Manager(String name, SeniorityLevel seniorityLevel, String departmentName) {
        super(name, seniorityLevel, null);
        this.departmentName = departmentName;
        this.team = new ArrayList<>();
        team.add(this);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    public void addEmployeeToTeam(Employee employee) {
        team.add(employee);
    }


}



public class SeniorityLevel {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Manager m1 = new Manager("Giorgos", Employee.SeniorityLevel.Senior, "IT");
        Manager m2 = new Manager("Jim", Employee.SeniorityLevel.Senior, "IT");
        Employee e1 = new Employee("Christos", Employee.SeniorityLevel.Mid, m1);
        Employee e2 = new Employee("Yiannis", Employee.SeniorityLevel.Junior, m1);
        Employee e3 = new Employee("Kostas", Employee.SeniorityLevel.Junior, m2);
        Employee e4 = new Employee("Christina", Employee.SeniorityLevel.Junior, m1);

        employees.add(m1);
        employees.add(m2);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        for (Employee e : e1.getMyColleagues()) {
            System.out.println("Name: " + e.getName() + ", Seniority: " + e.getSeniorityLevel());
        }
    }
}
