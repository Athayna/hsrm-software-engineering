package de.hsrm.mi.swt.spass.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

public class SemesterViewController extends ListCell<Semester> {

    private HBox leiste;
    private Label semZahl;
    private ListView<Modul> module;
    private Main main;
    private SemesterView view;
    private Studienplaner studienplaner;

    public SemesterViewController(Main main) {

        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new SemesterView();
        this.leiste = view.getLeiste();
        this.semZahl = view.getSemZahl();
        this.module = view.getModule();

        module.setOnDragEntered(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
		});

        module.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
		});

        module.setOnDragDetected(event -> {
            if( module.getSelectionModel().getSelectedItem()!= null){
			Dragboard db = module.startDragAndDrop(TransferMode.MOVE);
			ClipboardContent content = new ClipboardContent();
            content.putString(semZahl.getText()+ " " + module.getSelectionModel().getSelectedItem().getName());
            db.setContent(content);
            }
		});

        module.setOnDragDropped(event -> {
            String modulDaten = event.getDragboard().getString();
            String[] dndDaten = modulDaten.split(" ");
            int ausgangsSemester =  Integer.parseInt(dndDaten[0]);
            int zielSemester = Integer.parseInt(semZahl.getText());
            List<String> tempList = Arrays.asList(dndDaten);
            tempList.remove(0);
            String modulName = "";
            for (String string : tempList) { 
                modulName += string + " ";
            }
            modulName = modulName.trim(); // was lernen wir aus dieser Funktion? Das Python viel mehr Komfort bietet. 
            System.out.println(modulName);
            studienplaner.dragAndDrop(modulName, ausgangsSemester,zielSemester);
		});
        

    }

    @Override
    protected void updateItem(Semester item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            semZahl.setText(Integer.toString(item.getZahl()));
            semZahl.setId("semZahl");
            module.setItems(studienplaner.getStudiengang().getSemester().get((item.getZahl() - 1)).getModule());
            module.setCellFactory(mod -> new ModulViewController(main));

            setGraphic(leiste);
        } else {
            setGraphic(null);
            setText(null);
        }
    }

}
