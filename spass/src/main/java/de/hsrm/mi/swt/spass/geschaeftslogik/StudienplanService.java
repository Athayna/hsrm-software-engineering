package de.hsrm.mi.swt.spass.geschaeftslogik;

import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Studiengang;

public interface StudienplanService {

    public Studiengang studienplanLaden();
    
    public void studiengangSpeichern();
    
}
