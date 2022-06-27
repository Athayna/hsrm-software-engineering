package de.hsrm.mi.swt.spass.geschaeftslogik;

import java.util.List;


import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregel;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzen;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebot;

public class Studienplaner {

    private Studiengang studiengang;

    //private StudienplanServiceImpl simple = new StudienplanServiceImpl();


    public Studienplaner(){
        studiengang = InitStudiengang.erstelleStudiengang();
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
        if(checkForDnD(modul, zielSemester) && modul != null){
            studiengang.getSemester().get(zielSemester-1).getModule().add(modul);
            studiengang.getSemester().get(ausgangsSemester-1).getModule().remove(modul);
            System.out.println("Drag erfolgreich");
            return true;
        }
        System.out.println("Drag nicht erfolgreich");
        return false;
    }

    private boolean checkForDnD(Modul modul, int zielSemester){
        if(
        ValidateFortschrittsregel.validateState(studiengang, modul, zielSemester) &&
        ValidateKompetenzen.validateState(studiengang, modul, zielSemester) &&
        ValidateSemesterAngebot.validateState(studiengang, modul, zielSemester)
        ){
            return true;
        }
        return false;
    }


    
}
