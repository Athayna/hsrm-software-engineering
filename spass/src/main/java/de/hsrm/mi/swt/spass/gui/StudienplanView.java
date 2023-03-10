package de.hsrm.mi.swt.spass.gui;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;

public class StudienplanView extends AnchorPane{

    private Button datei;
    private Label name;
    private ListView<Semester> semester;
    private Button semHinzufuegen;
    private Button semTrim;

    public StudienplanView(int width, int height){
        
        VBox szene = new VBox();
        szene.setId("szene");
        
        HBox topleiste = new HBox();
        topleiste.setId("topleiste");
        datei = new Button("Datei");
        datei.setId("dateiButton");
        name = new Label("Semestername");
        name.setId("studiengangName");
        topleiste.getChildren().addAll(datei, name);

        semester = new ListView<>();
        semester.setId("semesterListe");
        semester.setOrientation(Orientation.VERTICAL);

        HBox reihe = new HBox();
        reihe.setId("untenButtonReihe");
        semHinzufuegen = new Button("Semester hinzufuegen");
        semHinzufuegen.setId("semHinzuButton");
        semTrim = new Button("Leer-Semester entfernen");
        semTrim.setId("semTrim");
        reihe.getChildren().addAll(semHinzufuegen, semTrim);

        szene.getChildren().addAll(topleiste, semester, reihe);

        this.getChildren().addAll(szene);
        StudienplanView.setTopAnchor(szene,height*0.0);
		StudienplanView.setBottomAnchor(szene,height*0.0);
		StudienplanView.setLeftAnchor(szene,width*0.0);
		StudienplanView.setRightAnchor(szene,width*0.0);

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

    public Button getSemTrim(){
        return semTrim;
    }

}