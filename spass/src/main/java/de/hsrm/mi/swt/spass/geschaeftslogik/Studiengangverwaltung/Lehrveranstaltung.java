package de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung;

import java.io.Serializable;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Lehrveranstaltung{

    private String name;
    private int cp;
    private int semAnzahl;
    private SimpleBooleanProperty bestanden;
    private SimpleFloatProperty note;
    private SimpleIntegerProperty fehlversuche;
    



    public Lehrveranstaltung(String name, int cp, int semAnzahl, boolean bestanden, float note, int fehlversuche) {
        this.name = name;
        this.cp = cp;
        this.semAnzahl = semAnzahl;
        this.bestanden = new SimpleBooleanProperty(bestanden);
        this.note = new SimpleFloatProperty(note);
        this.fehlversuche = new SimpleIntegerProperty(fehlversuche);
    }

    
    

}
