package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateSemesterAngebot {

    //@Override
    public boolean validateState(Studiengang studiengang, Modul modul, int zielSemester) {
        String semester = modul.getVerfuegbar();
        if(semester.equals("WiSe") && zielSemester%2!=1){
            System.out.println("Kein Wintersemester");
            return false;
        } else if(semester.equals("SoSe") && zielSemester%2!=0){
            System.out.println("Kein Sommersemester");
            return false;
        }
        return true;
    }
    
}
