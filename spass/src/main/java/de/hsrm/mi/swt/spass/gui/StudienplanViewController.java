package de.hsrm.mi.swt.spass.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.util.ArrayList;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class StudienplanViewController extends ViewController{

    private Studienplaner studienplaner;
    private StudienplanView view;
    private Button datei;
    private Label name;
    private ListView<Semester> semester;
    private Button semHinzufuegen;

    public StudienplanViewController(Main main){
        
        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new StudienplanView();
        this.datei = view.getDatei();
        this.name = view.getName();
        this.semester = view.getSemesterListe();
        this.semHinzufuegen = view.getSemHinzuButton();

        rootView = view;

        initialize();

    }

	@Override
	public void initialize() {

        datei.addEventHandler(ActionEvent.ACTION, event -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON Files", "*.json"));
            final File selectedFile = fileChooser.showOpenDialog(main.getStage());
            if (selectedFile != null) {
                
                studienplaner.ladePlan(selectedFile.getAbsolutePath());

            }
        });
		
        name.setText(studienplaner.getStudiengang().getName());
        semester.setItems(studienplaner.getStudiengang().getSemester());
        semester.setCellFactory(sem -> new SemesterViewController(main));

        semHinzufuegen.setOnAction(e -> {
            studienplaner.getStudiengang().getSemester().add(
                new Semester(
                    studienplaner.getStudiengang().getSemester().size() + 1,
                    0,
                    false,
                    new ArrayList<>()
                )
            );
        });

        //Studiengang laden
        datei.setOnAction(e -> {

        });
        
		
	}

}