package StudentGrades;

import java.util.ArrayList;

class School {
    private ArrayList<Student> students;

    public School() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}

class Student {
    private String surName;
    private String firstName;
    private ArrayList<Grade> grades;

    public Student(String surName, String firstName) {
        this.surName = surName;
        this.firstName = firstName;
        grades = new ArrayList<>();
    }

    public String getSurName() {
        return surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double calcAvgGrade() {
        double sum = 0.0;

        for (Grade grade : grades) {
            sum += grade.calcFinalGrade();
        }

        return sum / grades.size();
    }
}

class Grade {
    private double trimester1;
    private double trimester2;
    private double trimester3;
    private double exams;
    private Lesson lesson;

    public Grade(double trimester1, double trimester2, double trimester3, double exams, Lesson lesson) {
        this.trimester1 = trimester1;
        this.trimester2 = trimester2;
        this.trimester3 = trimester3;
        this.exams = exams;
        this.lesson = lesson;
    }

    public double getTrimester1() {
        return trimester1;
    }

    public double getTrimester2() {
        return trimester2;
    }

    public double getTrimester3() {
        return trimester3;
    }

    public double getExams() {
        return exams;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setTrimester1(double trimester1) {
        this.trimester1 = trimester1;
    }

    public void setTrimester2(double trimester2) {
        this.trimester2 = trimester2;
    }

    public void setTrimester3(double trimester3) {
        this.trimester3 = trimester3;
    }

    public void setExams(double exams) {
        this.exams = exams;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public double calcFinalGrade() {
        return 0.2 * ((trimester1 + trimester2 + trimester3) / 3) + 0.8 * exams;
    }
}

class Lesson {
    private String description;
    private ArrayList<Grade> grades;

    public Lesson(String description) {
        this.description = description;
        grades = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


public class StudentGrades {
    public static void main(String[] args) {
        Student s1 = new Student("Γεωργίου", "Νικόλαος");
        Student s2 = new Student("Παπαντωνίου", "Μαρία");

        Lesson mathimatika = new Lesson("Μαθηματικά");
        Lesson glossa = new Lesson("Γλώσσα");

        s1.addGrade(new Grade(9.0, 9.0, 8.0, 7.0, glossa));
        s1.addGrade(new Grade(10.0, 10.0, 10.0, 8.0, mathimatika));
        s2.addGrade(new Grade(10.0, 9.0, 10.0, 7.0, glossa));
        s2.addGrade(new Grade(8.0, 9.0, 10.0, 10.0, mathimatika));

        System.out.println("Ο μέσος όρος του μαθητή: " + s1.getSurName() + " " + s1.getFirstName() + ", είναι " + s1.calcAvgGrade());
    }
}
