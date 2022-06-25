package de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung;

import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Modul {

    private String name;
    private int cp;
    private SimpleBooleanProperty bestanden;
    private SimpleFloatProperty note;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public SimpleBooleanProperty getBestanden() {
        return bestanden;
    }

    public void setBestanden(SimpleBooleanProperty bestanden) {
        this.bestanden = bestanden;
    }

    public SimpleFloatProperty getNote() {
        return note;
    }

    public void setNote(SimpleFloatProperty note) {
        this.note = note;
    }

    public List<String> getGeforderteKompetenzen() {
        return geforderteKompetenzen;
    }

    public void setGeforderteKompetenzen(List<String> geforderteKompetenzen) {
        this.geforderteKompetenzen = geforderteKompetenzen;
    }

    public List<String> getKompetenzen() {
        return kompetenzen;
    }

    public void setKompetenzen(List<String> kompetenzen) {
        this.kompetenzen = kompetenzen;
    }

    public List<Lehrveranstaltung> getVeranst() {
        return veranst;
    }

    public void setVeranst(List<Lehrveranstaltung> veranst) {
        this.veranst = veranst;
    }

    public String getVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(String verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    public int getOrginalSemester() {
        return orginalSemester;
    }

    public void setOrginalSemester(int orginalSemester) {
        this.orginalSemester = orginalSemester;
    }

    

    
}
