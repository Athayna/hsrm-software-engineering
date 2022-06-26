package de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Studiengang;

public interface StudienplanService {

    public Studiengang studienplanLaden(String StudiengangName);
    
    public void studiengangSpeichern();
    
}
