package de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSemAnzahl() {
        return semAnzahl;
    }

    public void setSemAnzahl(int semAnzahl) {
        this.semAnzahl = semAnzahl;
    }

    public SimpleBooleanProperty getBestanden() {
        return bestanden;
    }

    public void setBestanden(SimpleBooleanProperty bestanden) {
        this.bestanden = bestanden;
    }

    public SimpleFloatProperty getNote() {
        return note;
    }

    public void setNote(SimpleFloatProperty note) {
        this.note = note;
    }

    public SimpleIntegerProperty getFehlversuche() {
        return fehlversuche;
    }

    public void setFehlversuche(SimpleIntegerProperty fehlversuche) {
        this.fehlversuche = fehlversuche;
    }
}
