package de.hsrm.mi.swt.spass.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Semester;
import javafx.scene.control.Button;

public class StudienplanView extends Pane{

    private Button datei;
    private Label name;
    private ListView<Semester> semester;
    private Button semHinzufuegen;

    public StudienplanView(){
        
        VBox szene = new VBox();
        
        HBox topleiste = new HBox();
        datei = new Button("Datei");
        name = new Label("Semestername");
        topleiste.setId("topleiste");
        topleiste.getChildren().addAll(datei, name);

        semester = new ListView<>();
        semHinzufuegen = new Button("Semester hinzufügen");

        szene.getChildren().addAll(topleiste, semester, semHinzufuegen);

        this.getChildren().addAll(szene);

    }

    public Button getDatei(){
        return datei;
    }

    public Label getName(){
        return name;
    }

    public ListView<Semester> getSemesterListe(){
        return semester;
    }

    public Button getSemHinzuButton(){
        return semHinzufuegen;
    }

}