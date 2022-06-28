//Semester
//Studiengang

@Testable
public class TestStudiengangverwaltung {

    private Lehrveranstaltung mathe1Vorl = new Lehrveranstaltung("Mathe1 Vorlesung", 5, 1, false, 0, 0);
    private Lehrveranstaltung mathe1Ueb = new Lehrveranstaltung("Mathe1 Übung", 0, 1, false, 0, 0);
    private Lehrveranstaltung prog1Vorl = new Lehrveranstaltung("Prog1 Vorlesung", 4, 1, false, 0, 0);
    private Lehrveranstaltung prog1Prak = new Lehrveranstaltung("Prog1 Praktikum", 3, 1, false, 0, 0);
    private Modul mathe1 = new Modul("Mathe1", 5, false, 0, Arrays.asList(""), Arrays.asList("logisches Denken","Mathematisches Grundverstaendnis"),
                Arrays.asList(mathe1Vorl, mathe1Ueb), "WiSe", 1);
    private Modul prog1 = new Modul("Programmieren1", 7, false, 0, Arrays.asList(""), Arrays.asList("Java Grundlagen"),
                Arrays.asList(prog1Prak, prog1Vorl), "WiSe", 1);
    private ObservableList<Modul> module = FXCollections.observableArrayList();
    

    @Test
    @Displayname("Modul loeschen")
    public void loescheModulTest(){
        module.addAll(mathe1,prog1);
        Semester semester = new Semester(1, 30, false,module);
        semester.loescheModul(mathe1);
        for (Modul modul : semester) {
        assertThat(modul.getName(),not(equalTo("mathe1")));
        }
    }

    @Test
    @Displayname("Semester hinzufuegen")
    public void semesterAddTest(){
        module.addAll(mathe1,prog1);
        Semester semester = new Semester(1, 30, false,module);
        Studiengang studiengang = new Studiengang("test", 10, 1, false, Arrays.asList(semester), 2, 10, Arrays.asList(""));

        studiengang.semesterHinzufuegen();
        assertThat(studiengang.)
    }
}
