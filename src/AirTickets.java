// Άσκηση 4.1 τελικών του 2021, για σύστημα κρατήσεων αεροπορικών εισιτηρίων

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

class Ticket {
    Reservation reservation;
    ArrayList<Leg> legList = new ArrayList<>();

    public Ticket(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public ArrayList<Leg> getLegList() {
        return legList;
    }

    public void addLeg(Leg leg) {
        legList.add(leg);
    }

    public boolean checkSameAirport() {
        String previousArrivalAirport = legList.get(0).getArrivalAirport();

        for (int i=1; i<legList.size(); i++) {
            if (!legList.get(i).getDepartureAirport().equals(previousArrivalAirport)) {
                return false;
            }
        }

        return true;
    }

    public String getTotalDuration() {
        int sum = 0;

        for (Leg leg : legList) {
            sum += leg.getDuration();
        }

        int hours = sum / 60;
        int minutes = sum % 60;

        return String.format("Συνολική διάρκεια πτήσεων: %d ώρες και %d λεπτά", hours, minutes);
    }

    @Override
    public String toString() {
        String printedString = "";

        for (Leg leg : legList) {
            String departureTime = String.valueOf(leg.getDepartureTime().toLocalTime());

            printedString += String.format("%s - %s \t %s \t\t %d λεπτά \n",
                    leg.getArrivalAirport(), leg.getDepartureAirport(), departureTime, leg.getDuration());
        }

        return printedString;
    }
}

class Reservation {
    private String name;
    private String id;

    public Reservation(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class Leg {
    private String departureAirport;
    private String arrivalAirport;
    private Date departureDate;
    private Time departureTime;
    private int duration;

    public Leg(String departureAirport, String arrivalAirport, Date departureDate, Time departureTime, int duration) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.duration = duration;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public int getDuration() {
        return duration;
    }
}

class AirTickets {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(new Reservation("Yiannis", "12345"));
        ticket.addLeg(new Leg("ATH", "FRA", new Date(2022, 6, 2), new Time(6,15,0), 180));
        ticket.addLeg(new Leg("FRA", "JFK", new Date(2022, 6, 2), new Time(11,10,0), 530));

        System.out.println(ticket);
        System.out.println(ticket.getTotalDuration());
    }
}