package de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Studiengang{

    private String name;
    private int cp;
    private int semanzahl;
    private String abschluss;
    private ObservableList<Semester> semester;
    private int fortschrittsregel;
    private int eigeneCpGrenze;
    private List<String> erlangteKompetenzen;

    public Studiengang(String name, int cp, int semanzahl, String abschluss, List<Semester> semester, int fortschrittsregel, int eigeneCpGrenze, List<String> erlangteKompetenzen) {
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

    public void semesterHinzufuegen(){
        int num = semester.size()+ 1 ;
        semester.add(new Semester(num, 0, false, new ArrayList<Modul>()));
    }




    
}
