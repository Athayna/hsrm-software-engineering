package de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.SaveLoadKlassen.StudiengangSL;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class StudienplanServiceImpl implements StudienplanService {

    @Override
    public Studiengang studienplanLaden(String path) {
        
        Gson gson = new Gson();

        SaveLoadKlassen helpMe = new SaveLoadKlassen();

        //String path = "src/main/resources/"+ studiengangName + ".json";

        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        StudiengangSL StudiengangSL = gson.fromJson(content, StudiengangSL.class);

        Studiengang studiengang = helpMe.getStudiengangFromSL(StudiengangSL);

        System.out.println("fertig?");

        return studiengang;

    }

    @Override
    public void studiengangSpeichern(Studiengang studiengang) {

        Gson gson = new Gson();

        SaveLoadKlassen helpMe = new SaveLoadKlassen();

        StudiengangSL miSL = helpMe.getSLStudiengang(studiengang);

        String path = "src/main/resources/"+studiengang.getName()+".json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(gson.toJson(miSL));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
