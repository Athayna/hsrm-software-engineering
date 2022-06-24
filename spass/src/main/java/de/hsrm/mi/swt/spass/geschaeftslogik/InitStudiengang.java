package de.hsrm.mi.swt.spass.geschaeftslogik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.google.gson.Gson;

import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Lehrveranstaltung;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Semester;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studiengangverwaltung.Studiengang;

public class InitStudiengang {

    public static void main(String[] args) {
        new InitStudiengang().testSpeichern();
    }

    public Studiengang erstelleStudiengang() {

        // 1. Sem
        Lehrveranstaltung mathe1Vorl = new Lehrveranstaltung("Mathe1 Vorlesung", 5, 1, false, 0, 0);
        Lehrveranstaltung mathe1Ueb = new Lehrveranstaltung("Mathe1 Übung", 0, 1, false, 0, 0);
        Lehrveranstaltung prog1Vorl = new Lehrveranstaltung("Prog1 Vorlesung", 3, 1, false, 0, 0);
        Lehrveranstaltung prog1Prak = new Lehrveranstaltung("Prog1 Praktikum", 2, 1, false, 0, 0);
        Lehrveranstaltung egesVorl = new Lehrveranstaltung("EGES Vorlesung", 3, 1, false, 0, 0);
        Lehrveranstaltung egesPrak = new Lehrveranstaltung("EGES Praktikum", 2, 1, false, 0, 0);
        Lehrveranstaltung miVorl = new Lehrveranstaltung("Medieninformatik Vorlesung", 3, 1, false, 0, 0);
        Lehrveranstaltung miPrak = new Lehrveranstaltung("Medieninformatik Praktikum", 2, 1, false, 0, 0);
        Lehrveranstaltung bwlVorl = new Lehrveranstaltung("BWL Vorlesung", 5, 1, false, 0, 0);
        Lehrveranstaltung bwlUeb = new Lehrveranstaltung("BWL Uebung", 0, 1, false, 0, 0);

        Modul mathe1 = new Modul("Mathe1", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(mathe1Vorl, mathe1Ueb), "WiSe", 1);
        Modul prog1 = new Modul("Programmieren1", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(prog1Prak, prog1Vorl), "WiSe", 1);
        Modul eges = new Modul("Eges", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(egesPrak, egesVorl), "WiSe", 1);
        Modul medieninfo = new Modul("Medieninformatik", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(miPrak, miVorl), "WiSe", 1);
        Modul bwl = new Modul("Bwl", 5, false, 0, Arrays.asList(""), Arrays.asList(""), Arrays.asList(bwlUeb, bwlVorl),
                "WiSe", 1);

        Semester erstesSemester = new Semester(1, 30, false, Arrays.asList(mathe1, prog1, eges, medieninfo, bwl));

        Studiengang medieninformatik = new Studiengang("Medieninformatik", 180, 7, "Darfst den Gong hauen",
                Arrays.asList(erstesSemester), 3, 17, Arrays.asList(""));
        return medieninformatik;
    }

    public void testSpeichern(){

        Studiengang medieninformatik = erstelleStudiengang();

        Gson gson = new Gson();

        

        String path = "src/main/java/de/hsrm/mi/swt/spass/geschaeftslogik/gang.json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(gson.toJson(medieninformatik));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testLaden() throws FileNotFoundException{

        Gson gson = new Gson();

        String path = "src/main/java/de/hsrm/mi/swt/spass/geschaeftslogik/gang.json";

        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        String stuff = readFile(path, StandardCharsets.UTF_8);

        gson.fromJson(stuff, Studiengang.class);
        
    }

}
