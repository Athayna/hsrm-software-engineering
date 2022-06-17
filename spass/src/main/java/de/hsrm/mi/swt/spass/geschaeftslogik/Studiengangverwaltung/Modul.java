package de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung;

import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Modul {

    private String name;
    private int cp;
    private SimpleBooleanProperty bestanden;
    private  SimpleFloatProperty note;
    private List<String> geforderteKompetenzen;
    private List<String> kompetenzen;
    private List<Lehrveranstaltung> veranst;
    private String verfuegbar;
    private int orginalSemester;

    public Modul(String name, int cp, boolean bestanden, float note,
            List<String> geforderteKompetenzen, List<String> kompetenzen, List<Lehrveranstaltung> veranst,
            String verfuegbar, int orginalSemester) {
        this.name = name;
        this.cp = cp;
        this.bestanden = new SimpleBooleanProperty(bestanden);
        this.note = new SimpleFloatProperty(note);
        this.geforderteKompetenzen = geforderteKompetenzen;
        this.kompetenzen = kompetenzen;
        this.veranst = veranst;
        this.verfuegbar = verfuegbar;
        this.orginalSemester = orginalSemester;
    }

    
}
