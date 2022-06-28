package de.hsrm.mi.swt.spass.gui;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregelError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzenError;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

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
            if (module.getSelectionModel().getSelectedItem() != null) {
                Dragboard db = module.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(semZahl.getText() + " " + module.getSelectionModel().getSelectedItem().getName());
                db.setContent(content);
            }
        });

        module.setOnDragDropped(event -> {
            String modulDaten = event.getDragboard().getString();
            String[] dndDaten = modulDaten.split(" ");
            int ausgangsSemester = Integer.parseInt(dndDaten[0]);
            int zielSemester = Integer.parseInt(semZahl.getText());
            List<String> tempList = new ArrayList<>();
            tempList = Arrays.asList(dndDaten);
            String modulName = "";
            for (int i = 1; i < tempList.size(); i++) {
                modulName += tempList.get(i) + " ";
            }
            modulName = modulName.trim(); // was lernen wir aus dieser Funktion? Das Python viel mehr Komfort bietet.
            try {
                studienplaner.dragAndDrop(modulName, ausgangsSemester, zielSemester);
            } catch (ValidateError e) {
                Alert alert = new Alert(AlertType.NONE);
                if (e instanceof ValidateKompetenzenError) {
                    alert.setAlertType(AlertType.WARNING);
                } else {
                    alert.setAlertType(AlertType.ERROR);
                }
                alert.setContentText(e.getMessage());
                alert.setHeight(300.0);
                alert.show();
            }
        });

    }

    @Override
    protected void updateItem(Semester item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            semZahl.setText(Integer.toString(item.getZahl()));
            semZahl.setId("semZahl");
            module.setItems(studienplaner.getStudiengang().getSemester().get((item.getZahl() - 1)).getModule());
            module.setCellFactory(mod -> new ModulViewController(main, item.getZahl()));

            setGraphic(leiste);
        } else {
            setGraphic(null);
            setText(null);
        }
    }

}
