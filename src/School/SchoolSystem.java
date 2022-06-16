package School;

import java.util.ArrayList;

interface CostEvaluation {
    double calcYearCost();
}

abstract class Room implements CostEvaluation {
    private String code;
    private double surface;

    public Room(String code, double surface) {
        this.code = code;
        this.surface = surface;
    }

    public String getCode() {
        return code;
    }

    public double getSurface() {
        return surface;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    @Override
    abstract public double calcYearCost();
}

class ClassRoom extends Room {

    public ClassRoom(String code, double surface) {
        super(code, surface);
    }

    @Override
    public double calcYearCost() {
        return 12 * (100 * super.getSurface());
    }
}

class Laboratory extends Room {
    private int runDevices;

    public Laboratory(String code, double surface, int runDevices) {
        super(code, surface);
        this.runDevices = runDevices;
    }

    public int getRunDevices() {
        return runDevices;
    }

    public void setRunDevices(int runDevices) {
        this.runDevices = runDevices;
    }

    @Override
    public double calcYearCost() {
        return 12 * (150 * runDevices);
    }
}

class School {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public School() {
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public double calcSchoolCost() {
        double totalCost = 0.0;

        for (Room room : rooms) {
            totalCost += room.calcYearCost();
        }

        return totalCost;
    }
}

class Teacher implements CostEvaluation {
    private String name;
    private double experienceYears;

    public Teacher(String name, double experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceYears(double experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public double calcYearCost() {
        return 14 * (1000 + 10 * experienceYears);
    }
}



public class SchoolSystem {

    public static void main(String[] args) {
        School school = new School();

        Teacher georgiou = new Teacher("ΓΕΩΡΓΙΟΥ", 5.6);
        Teacher antoniou = new Teacher("ΑΝΤΩΝΙΟΥ", 12);

        school.addTeacher(georgiou);
        school.addTeacher(antoniou);

        ClassRoom class1 = new ClassRoom("Class 1", 125.8);
        Laboratory lab1 = new Laboratory("Lab 1", 130, 5);

        school.addRoom(class1);
        school.addRoom(lab1);

        System.out.println("Το συνολικό κόστος λειτουργίας του σχολείου, είναι: " + school.calcSchoolCost());
    }
}
