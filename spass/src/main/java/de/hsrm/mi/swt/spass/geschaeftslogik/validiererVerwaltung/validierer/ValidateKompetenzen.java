package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import java.util.List;

import javax.sql.rowset.spi.SyncResolver;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateKompetenzen {
    

    public boolean validateState (Studiengang studiengang, Modul modul, int zielSemester, int ausgangsSemester) throws ValidateKompetenzenError {
        System.out.println(ausgangsSemester + " " + zielSemester);
        if (zielSemester < ausgangsSemester) {
            List<String> geforderteKompetenzen = modul.getGeforderteKompetenzen();
            gefunden: for (String gefordertekompetenz : geforderteKompetenzen) {
                for (int i = 0; i < zielSemester; i++) {
                    for (Modul m : studiengang.getSemester().get(i).getModule()) {
                        for (String kompetenz : m.getKompetenzen()) {
                            if (gefordertekompetenz.equals(kompetenz)) {
                                continue gefunden;
                            }
                        }
                    }
                }
                String msg = "Für das Modul '" + modul.getName() +"'' ist zu dem Zeitpunkt noch nicht die Kompetenz '" + gefordertekompetenz +"' erfuellt.";
                throw new ValidateKompetenzenError(msg);
                
            }
        } else if(ausgangsSemester < zielSemester){
            List<String> kompetenzen = modul.getKompetenzen();
            for(String kompetenz : kompetenzen){
                for (int i = ausgangsSemester; i < zielSemester; i++) {
                    for (Modul m : studiengang.getSemester().get(i).getModule()) {
                        if(m.getName().equals(modul.getName()) || m.getGeforderteKompetenzen().get(0).equals("")){
                            continue;
                        }
                        System.out.println(m.getName());
                        System.out.println(m.getGeforderteKompetenzen().size());
                        for (String geforderteKompetenz : m.getGeforderteKompetenzen()) {
                            if (kompetenz.equals(geforderteKompetenz)) {
                                if(m.getName().equals(modul.getName())){
                                    continue;
                                }
                                String msg = "Das Modul '" + m.getName() +"'' ist abhaenig von " + modul.getName() +" da es die Kompetenz '" + geforderteKompetenz + "' enthaelt";
                                throw new ValidateKompetenzenError(msg);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Kompetenzen validiert");
        return true;
    }
}