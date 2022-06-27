package de.hsrm.mi.swt.spass.gui;

import java.beans.EventHandler;

import javax.swing.plaf.basic.BasicTreeUI.MouseHandler;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModulViewController extends ListCell<Modul>{
    
    private HBox reihe;
    private VBox box;
    private Label name;
    private Button loeschen;
    private Label cp;
    private Main main;
    private Studienplaner studienplaner;
    private ModulView view;
    private int semZahl;

    public ModulViewController(Main main, int semZahl){

        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new ModulView();
        this.box = view.getBox();
        this.name = view.getName();
        this.cp = view.getCp();
        this.reihe = view.getReihe();
        this.loeschen = view.getLoeschen();
        this.semZahl = semZahl;

        loeschen.setOnAction(e -> {
            studienplaner.getStudiengang().getSemester().get(semZahl-1).loescheModul(name.getText());
        });

    }

    @Override
    protected void updateItem(Modul item, boolean empty){
        super.updateItem(item, empty);
        
        if(item != null){
            name.setText(item.getName());
            cp.setText(Integer.toString(item.getCp()));
            
            int boxBreite = item.getCp() * 35;
            box.setStyle("-fx-pref-width: "+ boxBreite + "px;");
            boxBreite -= 20;
            cp.setStyle("-fx-padding: 0px 0px 0px "+ boxBreite + "px;");


            setGraphic(box);
        }else{
            setGraphic(null);
            setText(null);
        }
    }
}
