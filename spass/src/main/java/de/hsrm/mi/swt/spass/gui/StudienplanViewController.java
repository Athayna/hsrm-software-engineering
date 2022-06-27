package de.hsrm.mi.swt.spass.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import de.hsrm.mi.swt.spass.Main;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.scene.control.Button;


public class StudienplanViewController extends ViewController{

    private Studienplaner studienplaner;
    private StudienplanView view;
    private Button datei;
    private Label name;
    private ListView<Semester> semester;
    private Button semHinzufuegen;
    private Button semTrim;

    public StudienplanViewController(Main main){
        
        this.main = main;
        this.studienplaner = main.getStudienplaner();
        this.view = new StudienplanView();
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
		
        name.setText(studienplaner.getStudiengang().getName());
        semester.setItems(studienplaner.getStudiengang().getSemester());
        semester.setCellFactory(sem -> new SemesterViewController(main));

        semHinzufuegen.setOnAction(e -> {
            studienplaner.getStudiengang().semesterHinzufuegen();
        });

        semTrim.setOnAction(e -> {
            studienplaner.getStudiengang().trimSemester();
        });

        //Studiengang laden
        datei.setOnAction(e -> {

        });
        
		
	}

}