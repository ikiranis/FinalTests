package Service;

import java.util.ArrayList;

/**
 * Created by Yiannis Kiranis <yiannis.kiranis@gmail.com>
 * https://apps4net.eu
 * Date: 13/6/22
 * Time: 8:51 μ.μ.
 *
 * Άσκηση 2, Τελικές 2018
 *
 */

abstract class Service {
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    abstract double calcWorksCost(double hoursOrSpace);
}

class BuildingService extends Service {

    @Override
    double calcWorksCost(double hoursOrSpace) {
        return 0;
    }
}

class GardenService extends Service {

    @Override
    double calcWorksCost(double hoursOrSpace) {
        return 0;
    }
}

class Task {

}

class Order {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Customer customer;
    private Payment payment;
}

class Customer {
    private ArrayList<Building> buildings = new ArrayList<>();
}

class Payment {

}

class Building {

}

class Apartment  extends Building {

}

class House extends Building {
    private Garden garden;
}

class Garden {

}

class Company {
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Service> services = new ArrayList<>();

    public double calcCostPerWork() {
        return 0;
    }
}

public class ServiceSystem {
    public static void main(String[] args) {

    }
}
