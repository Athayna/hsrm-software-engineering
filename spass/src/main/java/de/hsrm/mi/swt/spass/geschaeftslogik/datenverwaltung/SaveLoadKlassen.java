package de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung;

import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Lehrveranstaltung;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Semester;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung01.Studiengang;


public class SaveLoadKlassen {

    public StudiengangSL getSLStudiengang(Studiengang studiengang){
        return new StudiengangSL(studiengang);
    }

    public Studiengang getStudiengangFromSL(StudiengangSL stud){
        List<Semester> tempSem = new ArrayList<>();
        for (SemesterSL sem : stud.getSemester()) {
            List<Modul> tempMods = new ArrayList<>();
            for (ModulSL mod : sem.getModule()) {
                List<Lehrveranstaltung> tempLehr = new ArrayList<>();
                for (LehrveranstaltungSL lehr : mod.getVeranst()) {
                    tempLehr.add(new Lehrveranstaltung(lehr.getName(), lehr.getCp(), lehr.getSemAnzahl(), lehr.isBestanden(), lehr.getNote(), lehr.getFehlversuche()));
                }
                tempMods.add(new Modul(mod.getName(), mod.getCp(), mod.isBestanden(), mod.getNote(), mod.getGeforderteKompetenzen(), mod.getKompetenzen(), tempLehr, mod.getVerfuegbar(), mod.getOrginalSemester()));
            }
            tempSem.add( new Semester(sem.getZahl(), sem.getCp(), sem.isAbgeschlossen(), tempMods));
        }
        return new Studiengang(stud.getName(), stud.getCp(), stud.getSemanzahl(), stud.getAbschluss(), tempSem, stud.getFortschrittsregel(), stud.getEigeneCpGrenze(), stud.getErlangteKompetenzen());
    }


    public class LehrveranstaltungSL{

        private String name;
        private int cp;
        private int semAnzahl;
        private boolean bestanden;
        private float note;
        private int fehlversuche;

      

        public LehrveranstaltungSL(String name, int cp, int semAnzahl, boolean bestanden, float note, int fehlversuche) {
            this.name = name;
            this.cp = cp;
            this.semAnzahl = semAnzahl;
            this.bestanden = bestanden;
            this.note = note;
            this.fehlversuche = fehlversuche;
        }

        public LehrveranstaltungSL(Lehrveranstaltung lv){
            this.name = lv.getName();
            this.cp = lv.getCp();
            this.semAnzahl = lv.getSemAnzahl();
            this.bestanden = lv.getBestanden().get();
            this.note = lv.getNote().get();
            this.fehlversuche = lv.getFehlversuche().get();
        }

        public String getName() {
            return name;
        }

        public int getCp() {
            return cp;
        }

        public int getSemAnzahl() {
            return semAnzahl;
        }

        public boolean isBestanden() {
            return bestanden;
        }

        public float getNote() {
            return note;
        }

        public int getFehlversuche() {
            return fehlversuche;
        }

        

    }

    public class ModulSL {

        private String name;
        private int cp;
        private boolean bestanden;
        private float note;
        private List<String> geforderteKompetenzen;
        private List<String> kompetenzen;
        private List<LehrveranstaltungSL> veranst;
        private String verfuegbar;
        private int orginalSemester;

        public ModulSL(String name, int cp, boolean bestanden, float note, List<String> geforderteKompetenzen,
                List<String> kompetenzen, List<LehrveranstaltungSL> veranst, String verfuegbar, int orginalSemester) {
            this.name = name;
            this.cp = cp;
            this.bestanden = bestanden;
            this.note = note;
            this.geforderteKompetenzen = geforderteKompetenzen;
            this.kompetenzen = kompetenzen;
            this.veranst = veranst;
            this.verfuegbar = verfuegbar;
            this.orginalSemester = orginalSemester;
        }

        public ModulSL(Modul mod){
            this.name = mod.getName();
            this.cp = mod.getCp();
            this.bestanden = mod.getBestanden().get();
            this.note = mod.getNote().get();
            this.geforderteKompetenzen = mod.getGeforderteKompetenzen();
            this.kompetenzen = mod.getKompetenzen();

            List<LehrveranstaltungSL> temp = new ArrayList<>();
            for (Lehrveranstaltung lehrveranstaltung : mod.getVeranst()) {
                temp.add(new LehrveranstaltungSL(lehrveranstaltung));
            }
            this.veranst = temp;
            this.verfuegbar = mod.getVerfuegbar();
            this.orginalSemester = mod.getOrginalSemester();
        }

        public String getName() {
            return name;
        }

        public int getCp() {
            return cp;
        }

        public boolean isBestanden() {
            return bestanden;
        }

        public float getNote() {
            return note;
        }

        public List<String> getGeforderteKompetenzen() {
            return geforderteKompetenzen;
        }

        public List<String> getKompetenzen() {
            return kompetenzen;
        }

        public List<LehrveranstaltungSL> getVeranst() {
            return veranst;
        }

        public String getVerfuegbar() {
            return verfuegbar;
        }

        public int getOrginalSemester() {
            return orginalSemester;
        }

        
    }

    public class SemesterSL{

        private int zahl;
        private int cp;
        private boolean abgeschlossen;
        private List<ModulSL> module;

        public SemesterSL(int zahl, int cp, boolean abgeschlossen, List<ModulSL> module) {
            this.zahl = zahl;
            this.cp = cp;
            this.abgeschlossen = abgeschlossen;
            this.module = module;
        }

        public SemesterSL(Semester sem){
            this.zahl = sem.getZahl();
            this.cp = sem.getCp();
            this.abgeschlossen = sem.getAbgeschlossen().get();
            List<ModulSL> temp = new ArrayList<>();
            for (Modul modul : sem.getModule()) {
                temp.add(new ModulSL(modul));
            }
            this.module = temp;
        }

        public int getZahl() {
            return zahl;
        }

        public int getCp() {
            return cp;
        }

        public boolean isAbgeschlossen() {
            return abgeschlossen;
        }

        public List<ModulSL> getModule() {
            return module;
        }
    }

    public class StudiengangSL{

        private String name;
        private int cp;
        private int semanzahl;
        private String abschluss;
        private List<SemesterSL> semester;
        private int fortschrittsregel;
        private int eigeneCpGrenze;
        private List<String> erlangteKompetenzen;

        public StudiengangSL(String name, int cp, int semanzahl, String abschluss, List<SemesterSL> semester,
                int fortschrittsregel, int eigeneCpGrenze, List<String> erlangteKompetenzen) {
            this.name = name;
            this.cp = cp;
            this.semanzahl = semanzahl;
            this.abschluss = abschluss;
            this.semester = semester;
            this.fortschrittsregel = fortschrittsregel;
            this.eigeneCpGrenze = eigeneCpGrenze;
            this.erlangteKompetenzen = erlangteKompetenzen;
        }

        public StudiengangSL(Studiengang stud){
            this.name = stud.getName();
            this.cp = stud.getCp();
            this.semanzahl = stud.getSemanzahl();
            this.abschluss = stud.getAbschluss();
            this.fortschrittsregel = stud.getFortschrittsregel();
            this.eigeneCpGrenze = stud.getEigeneCpGrenze();
            this.erlangteKompetenzen = stud.getErlangteKompetenzen();

            List<SemesterSL> temp = new ArrayList<>();
            for (Semester semester : stud.getSemester()) {
                temp.add(new SemesterSL(semester));
            }
            
            this.semester = temp;
        }

        public String getName() {
            return name;
        }

        public int getCp() {
            return cp;
        }

        public int getSemanzahl() {
            return semanzahl;
        }

        public String getAbschluss() {
            return abschluss;
        }

        public List<SemesterSL> getSemester() {
            return semester;
        }

        public int getFortschrittsregel() {
            return fortschrittsregel;
        }

        public int getEigeneCpGrenze() {
            return eigeneCpGrenze;
        }

        public List<String> getErlangteKompetenzen() {
            return erlangteKompetenzen;
        }

        

    }











    
}
