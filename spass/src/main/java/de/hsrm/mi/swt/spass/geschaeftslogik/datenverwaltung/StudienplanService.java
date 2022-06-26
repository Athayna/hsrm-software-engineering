package de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public interface StudienplanService {

    public Studiengang studienplanLaden(String StudiengangName);
    
    public void studiengangSpeichern(Studiengang studiengang);
    
}
