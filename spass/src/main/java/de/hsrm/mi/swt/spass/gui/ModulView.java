package de.hsrm.mi.swt.spass.gui;

import javafx.scene.layout.VBox;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public class ModulView extends ListCell<Modul>{

    private VBox box;
    private Label name;
    private Label cp;

    public ModulView(){ 

        box = new VBox();
        box.setId("modulBox");
        name = new Label("Modul");
        cp = new Label("0");

        box.getChildren().addAll(name, cp);

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

    

}