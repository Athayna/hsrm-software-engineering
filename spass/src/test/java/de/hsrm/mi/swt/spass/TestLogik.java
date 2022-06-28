import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import de.hsrm.mi.swt.spass.geschaeftslogik.Studienplaner;

//Datenverwaltung Impl 
//Studienplaner

@Testable
public class TestLogik {
    
    //.studienplanLaden("src/main/resources/Medieninformatik.json")
    @Test
    void testStudienplanServiceInit_ladePlan(){
        Studienplaner studienplaner = new Studienplaner();
        assertThat(studienplaner.ladePlan("src/main/resources/Medieninformatik.json") instanceof Studiengang);
    }


    //drag and drop im studienplaner wirklich testen?? validates sind schließlich schon getestet
    @Test 
    void testStudienplaner_(){

    }

}
