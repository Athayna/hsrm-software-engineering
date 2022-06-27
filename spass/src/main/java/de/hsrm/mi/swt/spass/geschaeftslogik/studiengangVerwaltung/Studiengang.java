package de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Studiengang {

    private String name;
    private int cp;
    private int semanzahl;
    private String abschluss;
    private ObservableList<Semester> semester;
    private int fortschrittsregel;
    private int eigeneCpGrenze;
    private List<String> erlangteKompetenzen;

    public Studiengang(String name, int cp, int semanzahl, String abschluss, List<Semester> semester,
            int fortschrittsregel, int eigeneCpGrenze, List<String> erlangteKompetenzen) {
        this.name = name;
        this.cp = cp;
        this.semanzahl = semanzahl;
        this.abschluss = abschluss;
        this.semester = FXCollections.observableArrayList();
        this.semester.addAll(semester);

        this.fortschrittsregel = fortschrittsregel;
        this.eigeneCpGrenze = eigeneCpGrenze;
        this.erlangteKompetenzen = erlangteKompetenzen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSemanzahl() {
        return semanzahl;
    }

    public void setSemanzahl(int semanzahl) {
        this.semanzahl = semanzahl;
    }

    public String getAbschluss() {
        return abschluss;
    }

    public void setAbschluss(String abschluss) {
        this.abschluss = abschluss;
    }

    public ObservableList<Semester> getSemester() {
        return semester;
    }

    public void setSemester(ObservableList<Semester> semester) {
        this.semester = semester;
    }

    public int getFortschrittsregel() {
        return fortschrittsregel;
    }

    public void setFortschrittsregel(int fortschrittsregel) {
        this.fortschrittsregel = fortschrittsregel;
    }

    public int getEigeneCpGrenze() {
        return eigeneCpGrenze;
    }

    public void setEigeneCpGrenze(int eigeneCpGrenze) {
        this.eigeneCpGrenze = eigeneCpGrenze;
    }

    public List<String> getErlangteKompetenzen() {
        return erlangteKompetenzen;
    }

    public void setErlangteKompetenzen(List<String> erlangteKompetenzen) {
        this.erlangteKompetenzen = erlangteKompetenzen;
    }

    public void semesterHinzufuegen() {
        int num = semester.size() + 1;
        semester.add(new Semester(num, 0, false, new ArrayList<Modul>()));
    }

    public void trimSemester() {
        for (int i = semester.size()-1; i >= 0; i--) {
            if (semester.get(i).getModule().isEmpty()) {
                semester.remove(i);
            } else {
                break;
            }
        }
    }
}
