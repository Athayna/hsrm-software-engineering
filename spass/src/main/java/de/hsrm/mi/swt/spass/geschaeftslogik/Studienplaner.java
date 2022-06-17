package de.hsrm.mi.swt.spass.geschaeftslogik;

import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Studiengang;

public class Studienplaner {

    private Studiengang studiengang;
    private Datenverwalter datenverwalter;
    private Validierer validierer;

    public Studienplaner(){
        this.validierer = new Validierer();
        this.datenverwalter= new Datenverwalter(this);
        this.studiengang = datenverwalter.ladeStudiengang();



    }
    
}
