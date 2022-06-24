package de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung;

import java.io.Serializable;
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

}
