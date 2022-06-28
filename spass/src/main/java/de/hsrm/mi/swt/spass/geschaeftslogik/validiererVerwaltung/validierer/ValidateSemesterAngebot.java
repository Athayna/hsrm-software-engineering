package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateSemesterAngebot {

    //@Override
    public boolean validateState(Studiengang studiengang, Modul modul, int zielSemester) throws ValidateSemesterAngebotError {
        String semester = modul.getVerfuegbar();
        if(semester.equals("WiSe") && zielSemester%2!=1){
            String msg = modul.getName() + " findet nicht im Sommersemester statt!";
            throw new ValidateSemesterAngebotError(msg);
        } else if(semester.equals("SoSe") && zielSemester%2!=0){
            String msg = modul.getName() + " findet nicht im Wintersemester statt!";
            throw new ValidateSemesterAngebotError(msg);
        }
        System.out.println("Semesterzeit validiert");
        return true;
    }
    
}
