package de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.ValidateService;

public class validateFortschrittsregel implements ValidateService {

    private int fortschrittsBlockade;

    @Override
    public boolean validateState(Studiengang studiengang) {

        this.fortschrittsBlockade = studiengang.getFortschrittsregel();

        return true;
        
    }
    
}
