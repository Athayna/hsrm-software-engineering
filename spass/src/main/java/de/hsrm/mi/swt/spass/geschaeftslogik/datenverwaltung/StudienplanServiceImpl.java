package de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.google.gson.Gson;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.SaveLoadKlassen.StudiengangSL;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

public class StudienplanServiceImpl implements StudienplanService {

    @Override
    public Studiengang studienplanLaden(String studiengangName) {
        
        Gson gson = new Gson();

        SaveLoadKlassen helpMe = new SaveLoadKlassen();

        String path = "src/main/java/de/hsrm/mi/swt/spass/geschaeftslogik/recourcen/"+ studiengangName + ".json";

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
    public void studiengangSpeichern() {
        // TODO Auto-generated method stub
        
    }
    
}
