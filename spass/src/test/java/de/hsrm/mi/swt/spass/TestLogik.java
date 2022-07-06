package de.hsrm.mi.swt.spass;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import de.hsrm.mi.swt.spass.geschaeftslogik.InitStudiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;
import de.hsrm.mi.swt.spass.geschaeftslogik.datenverwaltung.StudienplanServiceImpl;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateError;

@Testable
public class TestLogik {
    private final Studiengang MEDIENINFORMATIK = InitStudiengang.erstelleStudiengang();

    @Test
    void testStudienplanServiceInit_ladePlan(){
        StudienplanServiceImpl helper = new StudienplanServiceImpl();
        assertTrue(helper.studienplanLaden("src/main/resources/Medieninformatik.json") instanceof Studiengang);
    }

    @Test 
    void testStudienplaner_dragAndDrop(){
        Studienplaner studienplaner = new Studienplaner("src/main/resources/Medieninformatik.json");
        assertTrue(studienplaner.dragAndDrop("BWL", 1, 3));
        assertThrows(ValidateError.class, () -> {studienplaner.dragAndDrop("Mathe 1", 1, 2);});

    }

    @Test 
    void testStudienplaner_checkDnd(){
        Studienplaner studienplaner = new Studienplaner("src/main/resources/Medieninformatik.json");
        assertTrue(studienplaner.checkForDnD(MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 3, 1));
        assertThrows(ValidateError.class, () -> {studienplaner.checkForDnD(MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 2, 1);});

    }


}
