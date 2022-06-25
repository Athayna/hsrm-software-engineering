package de.hsrm.mi.swt.spass.geschaeftslogik;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanService;
import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanServiceImpl;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class Studienplaner {

    private Studiengang studiengang;
    private StudienplanService studienplanService = new StudienplanServiceImpl();


    public Studienplaner(){
        studiengang = studienplanService.studienplanLaden("Medieninformatik");
    }

    public Studiengang getStudiengang(){
        return studiengang;
    }
    
}
