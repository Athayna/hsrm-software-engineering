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

    @Override
    protected void updateItem(Semester item, boolean empty){
        super.updateItem(item, empty);
        
        if(item != null){
            semZahl.setText(Integer.toString(item.getZahl()));
            //module.setItems(gameController.getObservables().getHighscore());
            //module.setCellFactory(mod -> new ModulView());

            setGraphic(leiste);
        }else{
            setGraphic(null);
            setText(null);
        }
    }

}