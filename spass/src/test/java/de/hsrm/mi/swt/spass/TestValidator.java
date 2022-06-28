package de.hsrm.mi.swt.spass;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import de.hsrm.mi.swt.spass.geschaeftslogik.InitStudiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregel;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregelError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzen;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzenError;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebot;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateSemesterAngebotError;

@Testable
public class TestValidator {
    private final Studiengang MEDIENINFORMATIK = InitStudiengang.erstelleStudiengang();

    @Test
    @DisplayName("Test Validator Kompetenz")
    void testKompetenz_validateState(){
        ValidateKompetenzen valKompetenzen = new ValidateKompetenzen();

        assertThrows(ValidateKompetenzenError.class, () -> {valKompetenzen.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 3, 1);});
        assertTrue(valKompetenzen.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(4), 3, 1));
        assertTrue(valKompetenzen.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(6).getModule().get(1), 5, 7));

    }

    @Test
    @DisplayName("Test Validator Fortschrittsregel")
    void testFortschrittsregel_validateState(){
        ValidateFortschrittsregel v = new ValidateFortschrittsregel();

        assertTrue(v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 3,1));
        assertTrue(v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(2).getModule().get(0), 1,3));
        assertThrows(ValidateFortschrittsregelError.class, () -> {v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 5, 1);});
        assertThrows(ValidateFortschrittsregelError.class, () -> {v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(4).getModule().get(0), 1, 5);});
    }

    //Studiengang studiengang, Modul modul, int zielSemester
    @Test
    @DisplayName("Test Validator Semester Angebot")
    void testSemAngebot_validateState(){
        ValidateSemesterAngebot valSemAngebot = new ValidateSemesterAngebot();
        assertThrows(ValidateSemesterAngebotError.class, () -> {valSemAngebot.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 2);});
        assertTrue(valSemAngebot.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(4), 3));
        assertTrue(valSemAngebot.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(4).getModule().get(2), 4));

    }

}
