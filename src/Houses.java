// Άσκηση 1, Τελικές 2020

import java.util.ArrayList;

abstract class Property {
    private int id;
    protected double assesedValue;
    protected int area;

    public Property(int id, double assesedValue, int area) {
        this.id = id;
        this.assesedValue = assesedValue;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateIncome();

    public String toString() {
        return String.valueOf(id);
    }
}

class Appartment extends Property {
    public Appartment(int id, double assesedValue, int area) {
        super(id, assesedValue, area);
    }

    @Override
    public double calculateIncome() {
        return assesedValue * area * 0.004;
    }

    @Override
    public String toString() {
        return "id: " + super.toString() + ", Διαμέρισμα";
    }
}

class Parking extends Property {
    private int carCapacity;

    public Parking(int id, double assesedValue, int area, int carCapacity) {
        super(id, assesedValue, area);
        this.carCapacity = carCapacity;
    }

    @Override
    public double calculateIncome() {
        return (assesedValue * area * 0.007) + (20 * carCapacity);
    }

    @Override
    public String toString() {
        return "id: " + super.toString() + ", Parking";
    }
}


public class Houses {
    public static void main(String[] args) {
        ArrayList<Property> properties = new ArrayList<>();

        properties.add(new Appartment(1, 2000, 100));
        properties.add(new Appartment(2, 3000, 140));
        properties.add(new Parking(3, 1300, 400, 30));

        double max = 0;
        int counter = 0;
        int maxIndex = 0;

        for (Property p : properties) {
            double income = p.calculateIncome();

            if (income > max) {
                max = income;
                maxIndex = counter;
                counter++;
            }
        }

        System.out.println("Το μεγαλύτερο εισόδημα είναι από το ακίνητο: " + properties.get(maxIndex));
    }
}
