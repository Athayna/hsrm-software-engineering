package de.hsrm.mi.swt.spass.gui;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class SemesterViewController extends ListCell<Semester>{
   
    private HBox leiste;
    private Label semZahl;
    private ListView<Modul> module;
    private Main main;
    private SemesterView view;
    private Studienplaner studienplaner;

    public SemesterViewController(Main main){

        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new SemesterView();
        this.leiste = view.getLeiste();
        this.semZahl = view.getSemZahl();
        this.module = view.getModule();

    }

    @Override
    protected void updateItem(Semester item, boolean empty){
        super.updateItem(item, empty);
        
        if(item != null){
            semZahl.setText(Integer.toString(item.getZahl()));
            module.setItems(studienplaner.getStudiengang().getSemester().get((item.getZahl()-1)).getModule());
            module.setCellFactory(mod -> new ModulView());

            setGraphic(leiste);
        }else{
            setGraphic(null);
            setText(null);
        }
    }

}
