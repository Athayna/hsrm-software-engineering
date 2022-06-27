package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateFortschrittsregel  {

    public boolean validateState(Studiengang studiengang, Modul modul, int semWish) {

        for (int i = semWish - 1; i < studiengang.getSemester().size(); i++) {
            for (Modul m : studiengang.getSemester().get(i).getModule()) {
                if (m.getOrginalSemester() <= (modul.getOrginalSemester() - studiengang.getFortschrittsregel())){
                    System.out.println("Fortschrittsregel verletzt");
                    return false;
                }
            }
        }

        
        System.out.println("Fortschrittsregel validiert");
        return true;    
    }  
}
