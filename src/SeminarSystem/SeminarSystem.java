package SeminarSystem;

import java.util.ArrayList;
import java.util.Date;

class School {
    private String name;
    private ArrayList<Teacher> schoolTeachers;
    private ArrayList<Seminar> currentSeminars;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Teacher> getSchoolTeachers() {
        return schoolTeachers;
    }

    public ArrayList<Seminar> getCurrentSeminars() {
        return currentSeminars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSchoolTeacher(Teacher teacher) {
        schoolTeachers.add(teacher);
    }

    public void addCurrentSeminar(Seminar seminar) {
        currentSeminars.add(seminar);
    }

    public Teacher findSeminarTeacher(Seminar seminar) {
        if (seminar.getSeminarTeacher() != null) {
            return seminar.getSeminarTeacher();
        }

        for (Teacher t : schoolTeachers) {
            if (t.isAvailable(seminar.getStart(), seminar.getFinish())) {
                seminar.setSeminarTeacher(t);
                t.addTeacherSeminars(seminar);
                return t;
            }
        }

        return null;
    }
}

abstract class Seminar {
    private String title;
    private Date start;
    private Date finish;
    private ArrayList<Student> seminarStudents;
    private Teacher seminarTeacher;
    public static final int ANNOUNCED = 1;
    public static final int CONFIRMED = 2;
    private School seminarSchool;


    public Seminar(String title, Date start, Date finish, School seminarSchool) {
        this.title = title;
        this.start = start;
        this.finish = finish;
        this.seminarSchool = seminarSchool;
        seminarStudents = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Teacher getSeminarTeacher() {
        return seminarTeacher;
    }

    public void setSeminarTeacher(Teacher seminarTeacher) {
        this.seminarTeacher = seminarTeacher;
    }

    public ArrayList<Student> getSeminarStudents() {
        return seminarStudents;
    }

    public void addSeminarStudents(Student student) {
        seminarStudents.add(student);
    }

    public School getSeminarSchool() {
        return seminarSchool;
    }

    public void setSeminarSchool(School seminarSchool) {
        this.seminarSchool = seminarSchool;
    }

    public abstract int getState();

    public int getTheState(int limit) {
        if(getSeminarStudents().size() > 5) {
            return CONFIRMED;
        }

        return ANNOUNCED;
    }
}

class FundedSeminar extends Seminar {

    public FundedSeminar(String title, Date start, Date finish, School seminarSchool) {
        super(title, start, finish, seminarSchool);
    }

    @Override
    public int getState() {
        return getTheState(5);
    }
}

class OpenSeminar extends Seminar {

    public OpenSeminar(String title, Date start, Date finish, School seminarSchool) {
        super(title, start, finish, seminarSchool);
    }

    @Override
    public int getState() {
        return getTheState(15);
    }
}

class Student {
    private String name;
    private ArrayList<Seminar> studentSeminars;

    public Student(String name) {
        this.name = name;
        studentSeminars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Seminar> getStudentSeminars() {
        return studentSeminars;
    }

    public void addStudentSeminar(Seminar seminar) {
        studentSeminars.add(seminar);
    }
}

class Teacher {
    private String name;
    private ArrayList<Seminar> teacherSeminars;
    private School teacherSchool;

    public Teacher(String name, School teacherSchool) {
        this.name = name;
        this.teacherSchool = teacherSchool;
        teacherSeminars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Seminar> getTeacherSeminars() {
        return teacherSeminars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeacherSeminars(Seminar seminar) {
        teacherSeminars.add(seminar);
    }

    public boolean isAvailable(Date start, Date finish) {
        for (Seminar s : teacherSeminars) {
            if (s.getStart().compareTo(finish) <= 0 && s.getFinish().compareTo(start) >= 0) {
                return false;
            }
        }

        return true;
    }

    public School getTeacherSchool() {
        return teacherSchool;
    }

    public void setTeacherSchool(School teacherSchool) {
        this.teacherSchool = teacherSchool;
    }
}


public class SeminarSystem {
}
