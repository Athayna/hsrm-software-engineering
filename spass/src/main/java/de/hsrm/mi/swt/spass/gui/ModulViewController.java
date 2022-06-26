package de.hsrm.mi.swt.spass.gui;

import java.util.HashMap;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class ModulViewController extends ListCell<Modul>{
    
    private VBox box;
    private Label name;
    private Label cp;
    private Main main;
    private ModulView view;

    public ModulViewController(Main main){

        this.main = main;
        this.view = new ModulView();
        this.box = view.getBox();
        this.name = view.getName();
        this.cp = view.getCp();

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
