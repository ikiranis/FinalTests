package CarsSystem;

import java.util.ArrayList;

class Person {
    private String name;
    private int age;
    private ArrayList<Vehicle> vehicles;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

}

abstract class Vehicle {
    private String constructor;
    private int numberOfWheels;
    private double maxSpeed;

    public Vehicle(String constructor, int numberOfWheels, double maxSpeed) {
        this.constructor = constructor;
        this.numberOfWheels = numberOfWheels;
        this.maxSpeed = maxSpeed;
    }

    public String getConstructor() {
        return constructor;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String toString() {
        return String.format("<constructor>%s</constructor>\n" +
                        "<numberOfWheels>%d</numberOfWheeels>\n" +
                        "<maxSpeed>%f</maxSpeed>\n",
                getConstructor(), getNumberOfWheels(), getMaxSpeed());
    }
}

abstract class Car extends Vehicle {
    private int enginePower;
    private int doors;

    public Car(String constructor, double maxSpeed, int enginePower, int doors) {
        super(constructor, 4, maxSpeed);
        this.enginePower = enginePower;
        this.doors = doors;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getDoors() {
        return doors;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return String.format(super.toString() +
                        "<enginePower>%d</enginePower>\n" +
                        "<doors>%d</doors>\n",
                getEnginePower(), getDoors());
    }
}

class Bike extends Vehicle {
    private boolean hasBasket;

    public Bike(String constructor, double maxSpeed, boolean hasBasket) {
        super(constructor, 2, maxSpeed);
        this.hasBasket = hasBasket;
    }

    public boolean isHasBasket() {
        return hasBasket;
    }

    public void setHasBasket(boolean hasBasket) {
        this.hasBasket = hasBasket;
    }

    @Override
    public String toString() {
        return String.format("<Bike>\n" +
                super.toString() +
                "<hasBasket>%b</hasBasket>\n" +
                "</Bike>",
                isHasBasket());
    }
}

class MotorCar extends Car {
    public enum FuelType {
        PETROL, DIESEL, GAS
    }

    private FuelType fuelType;
    private int engineVolume;

    public MotorCar(String constructor, double maxSpeed, int enginePower, int doors, FuelType fuelType, int engineVolume) {
        super(constructor, maxSpeed, enginePower, doors);
        this.fuelType = fuelType;
        this.engineVolume = engineVolume;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return String.format("<MotorCar>\n" +
                        super.toString() +
                        "<fuelType>%s</fuelType>\n" +
                        "<engineVolume>%d</engineVolume>\n" +
                        "</MotorCar>\n",
                getFuelType(), getEngineVolume());
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;
    private boolean useBreaksEnergyRecovery;

    public ElectricCar(String constructor, double maxSpeed, int enginePower, int doors, int batteryCapacity, boolean useBreaksEnergyRecovery) {
        super(constructor, maxSpeed, enginePower, doors);
        this.batteryCapacity = batteryCapacity;
        this.useBreaksEnergyRecovery = useBreaksEnergyRecovery;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public boolean isUseBreaksEnergyRecovery() {
        return useBreaksEnergyRecovery;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setUseBreaksEnergyRecovery(boolean useBreaksEnergyRecovery) {
        this.useBreaksEnergyRecovery = useBreaksEnergyRecovery;
    }

    @Override
    public String toString() {
        return String.format("<ElectricCar>\n" +
                        super.toString() +
                        "<batteryCapacity>%d</batteryCapacity>\n" +
                        "<useBreaksEnergyRecovery>%b</useBreaksEnergyRecovery>\n" +
                        "</ElectricCar>\n",
                getBatteryCapacity(), isUseBreaksEnergyRecovery());
    }
}



public class CarsSystem {

    public static void main(String[] args) {
        Person person = new Person("Γιώργος", 30);

        MotorCar toyota = new MotorCar("TOYOTA", 180, 115, 5, MotorCar.FuelType.PETROL, 1600);
        Bike yamaha = new Bike("YAMAHA", 200, true);

        person.addVehicle(toyota);
        person.addVehicle(yamaha);

        person.printVehicles();
    }
}
