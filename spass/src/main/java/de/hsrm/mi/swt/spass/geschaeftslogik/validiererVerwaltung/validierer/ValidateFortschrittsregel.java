package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class ValidateFortschrittsregel {

    public boolean validateState(Studiengang studiengang, Modul modul, int zielSemester, int ausgangsSemester) throws ValidateFortschrittsregelError{

        if (zielSemester < ausgangsSemester) {
            for (int i = zielSemester - 1; i < studiengang.getSemester().size(); i++) {
                for (Modul m : studiengang.getSemester().get(i).getModule()) {
                    if (m.getOrginalSemester() <= (modul.getOrginalSemester() - studiengang.getFortschrittsregel())) {
                        String msg = "Durch diese Verschiebung wuerde " + m.getName() + " die Fortschrittsregel verletzten.";
                        throw new ValidateFortschrittsregelError(msg);
                    }
                }
            }

        } else if (ausgangsSemester < zielSemester) {
            for (int i = zielSemester - 1; i > ausgangsSemester; i--) {
                for (Modul m : studiengang.getSemester().get(i).getModule()) {
                    if (m.getOrginalSemester() >= (modul.getOrginalSemester() + studiengang.getFortschrittsregel())) {
                        String msg = "Im " + zielSemester + ". Semester befinden sich Kurse, die ein fruehreres belegen von " + modul.getName() + " vorraussetzten.";
                        throw new ValidateFortschrittsregelError(msg); 
                    }
                }
            }
        }
        System.out.println("Fortschrittsregel validiert");
        return true;
    }
}
