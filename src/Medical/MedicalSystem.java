// Άσκηση 3, Επαναληπτικές 2020

package Medical;

import java.util.ArrayList;

abstract class MedicalService {
    protected String name;
    protected double insuranceCoveragePer;
    protected double insuranceCoverageLimit;

    public MedicalService(String name, double insuranceCoveragePer, double insuranceCoverageLimit) {
        this.name = name;
        this.insuranceCoveragePer = insuranceCoveragePer;
        this.insuranceCoverageLimit = insuranceCoverageLimit;
    }

    public String getName() {
        return name;
    }

    public abstract double getPatientParticipationCost();
    public abstract double getServiceTotalCost();

}

class HospitalCare extends MedicalService {
    private double dailyCost;
    private int days;

    public HospitalCare(String name, double insuranceCoveragePer, double insuranceCoverageLimit, double dailyCost, int days) {
        super(name, insuranceCoveragePer, insuranceCoverageLimit);
        this.dailyCost = dailyCost;
        this.days = days;
    }

    @Override
    public double getPatientParticipationCost() {
        double serviceTotalCost = getServiceTotalCost();

        if(dailyCost * insuranceCoveragePer > insuranceCoverageLimit) {
            return serviceTotalCost - days * insuranceCoverageLimit;
        }

        return serviceTotalCost - serviceTotalCost * insuranceCoveragePer;
    }

    @Override
    public double getServiceTotalCost() {
        return dailyCost * days;
    }
}

class MedicalExamination extends MedicalService {
    private double examinationCost;

    public MedicalExamination(String name, double insuranceCoveragePer, double insuranceCoverageLimit, double examinationCost) {
        super(name, insuranceCoveragePer, insuranceCoverageLimit);
        this.examinationCost = examinationCost;
    }

    @Override
    public double getPatientParticipationCost() {
        double serviceTotalCost = getServiceTotalCost();

        if(serviceTotalCost > insuranceCoverageLimit) {
            return serviceTotalCost - insuranceCoverageLimit;
        }

        return serviceTotalCost - serviceTotalCost * insuranceCoveragePer;
    }

    @Override
    public double getServiceTotalCost() {
        return examinationCost;
    }
}

public class MedicalSystem {
    public static void main(String[] args) {
        ArrayList<MedicalService> list = new ArrayList<>();

        list.add(new HospitalCare("ΑΜΥΓΔΑΛΕΚΤΟΜΗ", 0.35, 100, 200, 4));
        list.add(new MedicalExamination("ΓΕΝ. ΑΙΜΑΤΟΣ", 0.30, 60, 120));
        list.add(new MedicalExamination("ΑΞΟΝΙΚΗ", 0.40, 75, 200));

        for (MedicalService m : list) {
            System.out.println(m.getName() + " -> Συνολικό κόστος: " + m.getServiceTotalCost()
                + " Κόστος για τον ασθενή: " + m.getPatientParticipationCost()
                + " Ποσό που θα πληρώσει ο ΕΦΚΑ: " + (m.getServiceTotalCost() - m.getPatientParticipationCost()));
        }
    }
}
