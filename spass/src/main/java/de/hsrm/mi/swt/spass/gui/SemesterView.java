package de.hsrm.mi.swt.spass.gui;

import javafx.scene.layout.HBox;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;

public class SemesterView extends ListCell<Semester>{

    private HBox leiste;
    private Label semZahl;
    private ListView<Modul> module;

    public SemesterView(){ 

        leiste = new HBox();
        semZahl = new Label("0");
        module = new ListView<>();
        module.setOrientation(Orientation.HORIZONTAL);
        leiste.getChildren().addAll(semZahl, module);

        this.setGraphic(leiste);

    }

    public HBox getLeiste() {
        return leiste;
    }

    public void setLeiste(HBox leiste) {
        this.leiste = leiste;
    }

    public Label getSemZahl() {
        return semZahl;
    }

    public void setSemZahl(Label semZahl) {
        this.semZahl = semZahl;
    }

    public ListView<Modul> getModule() {
        return module;
    }

    public void setModule(ListView<Modul> module) {
        this.module = module;
    }

    
    
}