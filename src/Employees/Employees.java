// Άσκηση 3, Τελικές 2020

package Employees;

import java.util.ArrayList;

interface User {
    double getServiceRate();
}

class Employee implements User {
    private String name;
    private double serviceRate;

    public Employee(String name, double serviceRate) {
        this.name = name;
        this.serviceRate = serviceRate;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getServiceRate() {
        return serviceRate;
    }
}

class Customer implements User {
    private String name;
    private double serviceRate;

    public Customer(String name, double serviceRate) {
        this.name = name;
        this.serviceRate = serviceRate;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getServiceRate() {
        return serviceRate;
    }
}

class Employees {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User e1 = new Employee("Yiannis", 20.0);
        User e2 = new Employee("Yiorgos", 30.0);
        User c1 = new Customer("Panagiotis", 35.0);
        User c2 = new Customer("Dimitris", 25.0);

        users.add(e1);
        users.add(e2);
        users.add(c1);
        users.add(c2);

        double sum = 0;

        for (User u : users) {
            sum += u.getServiceRate();
        }

        System.out.println("Συνολικό κόστος εξυπηρέτησης: " + sum);

    }
}