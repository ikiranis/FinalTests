package Garage;

import java.util.ArrayList;

interface Income {
    public double getSalesCost();
}

interface Expense {
    public double getPurchaseCost();
}

class Service implements Income {
    private String name;
    private double cost;
    private ArrayList<Part> parts;

    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.parts = new ArrayList<>();
    }

    @Override
    public double getSalesCost() {
        double partsCost = 0;

        for (Part part : parts) {
            partsCost += part.getSalesCost();
        }

        return partsCost + cost;
    }
}

class Part implements Income, Expense {
    private String name;
    private double salesCost;
    private double purchaceCost;

    public Part(String name, double salesCost, double purchaceCost) {
        this.name = name;
        this.salesCost = salesCost;
        this.purchaceCost = purchaceCost;
    }

    @Override
    public double getSalesCost() {
        return salesCost;
    }

    @Override
    public double getPurchaseCost() {
        return purchaceCost;
    }
}



public class Garage {
    public static void main(String[] args) {

    }
}
