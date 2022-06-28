package de.hsrm.mi.swt.spass.gui;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ModulView extends ListCell<Modul>{

    private HBox reihe;
    private VBox box;
    private Label name;
    private Button loeschen;
    private Label cp;

    public ModulView(){ 

        box = new VBox();
        box.setId("modulBox");

        reihe = new HBox();
        name = new Label("Modul");
        name.setId("modulBoxName");
        loeschen = new Button("X");
        loeschen.setId("loescheModul");
        reihe.getChildren().addAll(name, loeschen);

        cp = new Label("0");
        cp.setId("modulCpBox");

        box.getChildren().addAll(reihe, cp);

        this.setGraphic(box);

    }

    public VBox getBox() {
        return box;
    }

    public Label getName() {
        return name;
    }

    public Label getCp() {
        return cp;
    }

    public HBox getReihe() {
        return reihe;
    }

    public Button getLoeschen() {
        return loeschen;
    }

    
    

}