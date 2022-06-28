package de.hsrm.mi.swt.spass;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanServiceImpl;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;

@Testable
public class TestLogik {
    
    //.studienplanLaden("src/main/resources/Medieninformatik.json")
    @Test
    void testStudienplanServiceInit_ladePlan(){
        StudienplanServiceImpl helper = new StudienplanServiceImpl();
        assertTrue(helper.studienplanLaden("src/main/resources/Medieninformatik.json") instanceof Studiengang);
    }


    //drag and drop im studienplaner wirklich testen?? validates sind schließlich schon getestet
    @Test 
    void testStudienplaner_(){

    }

}
