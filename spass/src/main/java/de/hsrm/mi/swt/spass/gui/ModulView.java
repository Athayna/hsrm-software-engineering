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

    @Override
    protected void updateItem(Modul item, boolean empty){
        super.updateItem(item, empty);
        
        if(item != null){
            name.setText(item.getName());
            cp.setText(Integer.toString(item.getCp()));
            int boxBreite = item.getCp() * 32;
            box.setStyle("-fx-pref-width: "+ boxBreite + "px;");

            setGraphic(box);
        }else{
            setGraphic(null);
            setText(null);
        }
    }

}