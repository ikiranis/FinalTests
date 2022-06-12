package Airport;

import java.util.ArrayList;

/**
 * Created by Yiannis Kiranis <yiannis.kiranis@gmail.com>
 * https://apps4net.eu
 * Date: 12/6/22
 * Time: 7:40 μ.μ.
 */

abstract class AirplaneCharge {
    private int minutesOfStay;

    public AirplaneCharge(int minutesOfStay) {
        this.minutesOfStay = minutesOfStay;
    }

    public int getMinutesOfStay() {
        return minutesOfStay;
    }

    abstract public double calculateCharge();
}

class CivilAirplaneCharge extends AirplaneCharge {
    private int passengersNum;

    public CivilAirplaneCharge(int minutesOfStay, int passengersNum) {
        super(minutesOfStay);
        this.passengersNum = passengersNum;
    }

    @Override
    public double calculateCharge() {
        return passengersNum * 1.2 + getMinutesOfStay() * 10;
    }
}

class CargoAirplaneCharge extends AirplaneCharge {
    private int weight;

    public CargoAirplaneCharge(int minutesOfStay, int weight) {
        super(minutesOfStay);
        this.weight = weight;
    }

    @Override
    public double calculateCharge() {
        return weight * 30 + getMinutesOfStay() * 15;
    }
}

class HandlingCase {
    private String chargeScheme;
    private String flightNumber;
    private AirplaneCharge airplaneCharge;

    public HandlingCase(String flightNumber, AirplaneCharge airplaneCharge) {
        this.flightNumber = flightNumber;
        this.airplaneCharge = airplaneCharge;

        if(airplaneCharge instanceof CivilAirplaneCharge) {
            chargeScheme = "Passengers Airplane Charge";
        } else {
            chargeScheme = "Cargo Airplane Charge";
        }
    }

    public String getChargeScheme() {
        return chargeScheme;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AirplaneCharge getAirplaneCharge() {
        return airplaneCharge;
    }
}

class AirportCustomerManager {
    private ArrayList<HandlingCase> handlingCases = new ArrayList<>();

    public double calculateTotalIncome() {
        double totalIncome = 0;

        for (HandlingCase h : handlingCases) {
            totalIncome += h.getAirplaneCharge().calculateCharge();
        }

        return totalIncome;
    }

    public void addHandlingCase(HandlingCase handlingCase) {
        handlingCases.add(handlingCase);
    }

    public HandlingCase getMaxCase() {
        double maxCharge = 0;
        HandlingCase handlingCase = null;

        for (HandlingCase h : handlingCases) {
            double caseCharge = h.getAirplaneCharge().calculateCharge();

            if (caseCharge > maxCharge) {
                maxCharge = caseCharge;
                handlingCase = h;
            }
        }

        return handlingCase;
    }
}

public class AirportSystem {
    public static void main(String[] args) {
        AirportCustomerManager airportCustomerManager = new AirportCustomerManager();

        airportCustomerManager.addHandlingCase(new HandlingCase("FX100", new CargoAirplaneCharge(30, 150)));
        airportCustomerManager.addHandlingCase(new HandlingCase("FX101", new CivilAirplaneCharge(120, 300)));
        airportCustomerManager.addHandlingCase(new HandlingCase("FX102", new CivilAirplaneCharge(80, 100)));
        airportCustomerManager.addHandlingCase(new HandlingCase("FX103", new CargoAirplaneCharge(45, 200)));
        airportCustomerManager.addHandlingCase(new HandlingCase("FX104", new CargoAirplaneCharge(145, 230)));
        airportCustomerManager.addHandlingCase(new HandlingCase("FX105", new CivilAirplaneCharge(20, 156)));

        System.out.println("Total Income: " + airportCustomerManager.calculateTotalIncome() + " euros");
        System.out.println("---------------------------");
        HandlingCase maxCase = airportCustomerManager.getMaxCase();
        System.out.println("Max case info");
        System.out.println("\tFlight No: " + maxCase.getFlightNumber());
        System.out.println("\tCharge: " + maxCase.getAirplaneCharge().calculateCharge());
        System.out.println("\tCharge Type: " + maxCase.getChargeScheme());
    }
}
