package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class validateSemesterAngebot {

    //@Override
    public boolean validateState(Studiengang studiengang) {

        for (Semester sem : studiengang.getSemester()) {
            for (Modul mod : sem.getModule()) {
                if(mod.getVerfuegbar().equals("SoSe")){
                    if(sem.getZahl()%2!=0){
                        return false;
                    }
                } else if(mod.getVerfuegbar().equals("WiSe")){
                    if(sem.getZahl()%2!=1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}
