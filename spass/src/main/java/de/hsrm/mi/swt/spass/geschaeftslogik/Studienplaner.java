package de.hsrm.mi.swt.spass.geschaeftslogik;

import java.util.List;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanServiceImpl;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregel;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzen;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebot;

public class Studienplaner {

    private Studiengang studiengang;
    private StudienplanServiceImpl helper= new StudienplanServiceImpl();
    private ValidateFortschrittsregel val1 = new ValidateFortschrittsregel();
    private ValidateKompetenzen val2 = new ValidateKompetenzen();
    private ValidateSemesterAngebot val3 = new ValidateSemesterAngebot();

    //private StudienplanServiceImpl simple = new StudienplanServiceImpl();


    public Studienplaner(){
        studiengang = helper.studienplanLaden("Medieninformatik");
    }

    public Studiengang getStudiengang(){
        return studiengang;
    }

    public boolean dragAndDrop(String modulName,int ausgangsSemester, int zielSemester){
        
        List<Modul> ausgangsSemesterModule = studiengang.getSemester().get(ausgangsSemester-1).getModule();
        Modul modul = null;
        for (Modul mod : ausgangsSemesterModule) {
            if(mod.getName().equals(modulName)){
                modul = mod;
                break;
            }
        }
        // add modul to its new semester, removes it of the old one
        if(checkForDnD(modul, zielSemester, ausgangsSemester) && modul != null){
            studiengang.getSemester().get(zielSemester-1).getModule().add(modul);
            studiengang.getSemester().get(ausgangsSemester-1).getModule().remove(modul);
            System.out.println("Drag erfolgreich \n");
            return true;
        }
        System.out.println("Drag nicht erfolgreich \n");
        return false;
    }

    private boolean checkForDnD(Modul modul, int zielSemester, int ausgangsSemester){
        if(
        val1.validateState(studiengang, modul, zielSemester) &&
        val2.validateState(studiengang, modul, zielSemester, ausgangsSemester) &&
        val3.validateState(studiengang, modul, zielSemester)
        ){
            return true;
        }
        return false;
    }


    
}
