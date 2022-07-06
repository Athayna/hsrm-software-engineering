package de.hsrm.mi.swt.spass.geschaeftslogik;

import java.util.List;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanServiceImpl;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregel;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregelError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzen;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzenError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebot;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebotError;

public class Studienplaner {

    private Studiengang studiengang;
    private StudienplanServiceImpl helper = new StudienplanServiceImpl();
    private ValidateFortschrittsregel valFort = new ValidateFortschrittsregel();
    private ValidateKompetenzen valKomp = new ValidateKompetenzen();
    private ValidateSemesterAngebot valSem = new ValidateSemesterAngebot();

    // private StudienplanServiceImpl simple = new StudienplanServiceImpl();

    public Studienplaner() {
        studiengang = helper.studienplanLaden("src/main/resources/Medieninformatik.json");
        //studiengang = InitStudiengang.erstelleStudiengang();
    }

    public Studienplaner(String path) {
        studiengang = helper.studienplanLaden(path);
    }

    public void ladePlan(String path) {
        studiengang = helper.studienplanLaden(path);
    }

    public Studiengang getStudiengang() {
        return studiengang;
    }

    public boolean dragAndDrop(String modulName, int ausgangsSemester, int zielSemester) throws ValidateError {

        List<Modul> ausgangsSemesterModule = studiengang.getSemester().get(ausgangsSemester - 1).getModule();
        Modul modul = null;
        for (Modul mod : ausgangsSemesterModule) {
            if (mod.getName().equals(modulName)) {
                modul = mod;
                break;
            }
        }
        // add modul to its new semester, removes it of the old one

        if (modul != null) {
            try {
                if (checkForDnD(modul, zielSemester, ausgangsSemester)) {
                    
                    studiengang.getSemester().get(zielSemester - 1).getModule().add(modul);
                    studiengang.getSemester().get(ausgangsSemester - 1).getModule().remove(modul);
                    System.out.println("Drag erfolgreich \n");
                    try{
                        valKomp.validateState(studiengang, modul, zielSemester, ausgangsSemester);
                    }catch(ValidateKompetenzenError eKomp){
                        throw new ValidateKompetenzenError(eKomp.getMessage());
                    }
                    return true;
                }
            } catch (ValidateKompetenzenError e) {
                System.out.println("Drag erfolgreich, mit Fehler \n");
                throw e;
            } catch (ValidateError e) {
                String fehler = e.getMessage() + "\n";
                try{
                    valKomp.validateState(studiengang, modul, zielSemester, ausgangsSemester);
                }catch(ValidateKompetenzenError eKomp){
                    fehler += eKomp.getMessage();
                }
                throw new ValidateError(fehler);
            }
        }
        return false;

    }

    public boolean checkForDnD(Modul modul, int zielSemester, int ausgangsSemester) throws ValidateError {
            String fehler = "";
            boolean dragAndDropEnabled = true;
            try{
                valFort.validateState(studiengang, modul, zielSemester, ausgangsSemester);
            }catch(ValidateFortschrittsregelError e){
                fehler += e.getMessage() + "\n\n";
                dragAndDropEnabled = false;
            }
            try{
                valSem.validateState(studiengang, modul, zielSemester);
            }catch(ValidateSemesterAngebotError e){
                fehler += e.getMessage() + "\n";
                dragAndDropEnabled = false;
            }

            if(dragAndDropEnabled){
                return true;
            }else{
                throw new ValidateError(fehler);
            }
    }

    public ValidateFortschrittsregel getValFort() {
        return valFort;
    }

    public ValidateKompetenzen getValKomp() {
        return valKomp;
    }

    public ValidateSemesterAngebot getValSem() {
        return valSem;
    }

    

}
