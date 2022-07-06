package de.hsrm.mi.swt.spass.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.util.List;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class StudienplanViewController extends ViewController{

    private Studienplaner studienplaner;
    private StudienplanView view;
    private Button datei;
    private Label name;
    private ListView<Semester> semester;
    private Button semHinzufuegen;
    private Button semTrim;
    private ObservableList<Semester> revSem = FXCollections.observableArrayList();


    public StudienplanViewController(Main main){
        
        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new StudienplanView(main.getWIDTH(), main.getHEIGHT());
        this.datei = view.getDatei();
        this.name = view.getName();
        this.semester = view.getSemesterListe();
        this.semHinzufuegen = view.getSemHinzuButton();
        this.semTrim = view.getSemTrim();

        rootView = view;

        initialize();

    }

	@Override
	public void initialize() {

        revSem.addAll(studienplaner.getStudiengang().getSemester());
        FXCollections.reverse(revSem);

        name.setText(studienplaner.getStudiengang().getName());
        semester.setItems(revSem);
        semester.setCellFactory(sem -> new SemesterViewController(main));
        
        datei.addEventHandler(ActionEvent.ACTION, event -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new ExtensionFilter("JSON Files", "*.json"));
            final File selectedFile = fileChooser.showOpenDialog(main.getStage());
            if (selectedFile != null) {
                studienplaner.ladePlan(selectedFile.getAbsolutePath());
                name.setText(studienplaner.getStudiengang().getName());
                semester.setItems(revSem);
                semester.setCellFactory(sem -> new SemesterViewController(main));
            }
        });

        studienplaner.getStudiengang().getSemester().addListener( new ListChangeListener<Semester>() {

            @Override
            public void onChanged(Change<? extends Semester> c) {
                revSem.clear();
                revSem.addAll(studienplaner.getStudiengang().getSemester());
                FXCollections.reverse(revSem);
            }
            
        });

        semHinzufuegen.setOnAction(e -> {
            studienplaner.getStudiengang().semesterHinzufuegen();

        });

        semTrim.setOnAction(e -> {
            studienplaner.getStudiengang().trimSemester();
  
        });
        
		
	}

}