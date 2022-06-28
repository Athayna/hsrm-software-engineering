import de.hsrm.mi.swt.spass.geschaeftslogik.InitStudiengang;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateFortschrittsregel;
import de.hsrm.mi.swt.spass.geschaeftslogik.validiererVerwaltung.validierer.ValidateKompetenzen;

//alle 3 Validator
@Testable
public class TestValidator {
    private final Studiengang MEDIENINFORMATIK = new InitStudiengang();

    @Test
    @DisplayName("Test Validator Kompetenz")
    void testKompetenz_validateState(){
        ValidateKompetenzen valKompetenzen = new ValidateKompetenzen();
        assertThrows(ValidateKompetenzenError.class, () -> {valKompetenzen.validateState ("Medieninformatik", MEDIENINFORMATIK.getStudiengang.getSemester.get(0).getModule().get(0), 3, 1);});
        assertTrue(validateState ("Medieninformatik", MEDIENINFORMATIK.getStudiengang.getSemester.get(0).getModule().get(4), 3, 1));

    }

    @Test
    @DisplayName("Test Validator Fortschrittsregel")
    void testFortschrittsregel_validateState(){

        ValidateFortschrittsregel v = new ValidateFortschrittsregel();
        assertTrue(v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 3));
        assertTrue(v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(2).getModule().get(0), 1));
        assertThrows(ValidateFortschrittsregelError.class, () -> {v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 5);});
        assertThrows(ValidateFortschrittsregelError.class, () -> {v.validateState(MEDIENINFORMATIK, MEDIENINFORMATIK.getSemester().get(0).getModule().get(0), 5);});
    }
}
