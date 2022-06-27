package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import java.util.List;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateKompetenzen {

    public boolean validateState(Studiengang studiengang, Modul modul, int semWish) {
       
        List<String> geforderteKompetenzen = modul.getGeforderteKompetenzen();

        gefunden:
        for (String gefordertekompetenz : geforderteKompetenzen) {
            for (int i = 0; i < semWish; i++) {
                for (Modul m : studiengang.getSemester().get(i).getModule()) {
                    for(String kompetenz : m.getKompetenzen()){
                        if(gefordertekompetenz.equals(kompetenz)){
                            continue gefunden;
                        }
                    }           
                }           
            } 
            System.out.println("Fehlende Kompetenzen"); 
            return false;
        }
        System.out.println("Kompetenzen validiert");
        return true;
    }
}