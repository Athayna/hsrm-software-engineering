package de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung;
import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Semester{

    private int zahl;
    private int cp;
    private SimpleBooleanProperty abgeschlossen;
    private ObservableList<Modul> module;

    public Semester(int zahl, int cp, boolean abgeschlossen, List<Modul> module) {
        this.zahl = zahl;
        this.cp = cp;
        this.abgeschlossen = new SimpleBooleanProperty(abgeschlossen);
        this.module = FXCollections.observableArrayList();
        this.module.addAll(module);
    }

    public void modulHinzufuegen(Modul m) {
        module.add(m);
    }

    public void modulLoeschen(Modul m) {
        module.remove(m);
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public SimpleBooleanProperty getAbgeschlossen() {
        return abgeschlossen;
    }

    public void setAbgeschlossen(SimpleBooleanProperty abgeschlossen) {
        this.abgeschlossen = abgeschlossen;
    }

    public ObservableList<Modul> getModule() {
        return module;
    }

    public void setModule(ObservableList<Modul> module) {
        this.module = module;
    }

    

}
