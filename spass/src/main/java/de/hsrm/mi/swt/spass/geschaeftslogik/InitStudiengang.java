package de.hsrm.mi.swt.spass.geschaeftslogik;

import java.util.Arrays;

import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Lehrveranstaltung;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Modul;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Semester;
import de.hsrm.mi.swt.spass.geschaeftslogik.studiengangVerwaltung.Studiengang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InitStudiengang {

    public static Studiengang erstelleStudiengang() {

        // 1. Sem
        Lehrveranstaltung mathe1Vorl = new Lehrveranstaltung("Mathe1 Vorlesung", 5, 1, false, 0, 0);
        Lehrveranstaltung mathe1Ueb = new Lehrveranstaltung("Mathe1 Übung", 0, 1, false, 0, 0);
        Lehrveranstaltung prog1Vorl = new Lehrveranstaltung("Prog1 Vorlesung", 4, 1, false, 0, 0);
        Lehrveranstaltung prog1Prak = new Lehrveranstaltung("Prog1 Praktikum", 3, 1, false, 0, 0);
        Lehrveranstaltung egesVorl = new Lehrveranstaltung("EGES Vorlesung", 0, 1, false, 0, 0);
        Lehrveranstaltung egesPrak = new Lehrveranstaltung("EGES Praktikum", 8, 1, false, 0, 0);
        Lehrveranstaltung miVorl = new Lehrveranstaltung("Medieninformatik Vorlesung", 3, 1, false, 0, 0);
        Lehrveranstaltung miPrak = new Lehrveranstaltung("Medieninformatik Praktikum", 2, 1, false, 0, 0);
        Lehrveranstaltung bwlVorl = new Lehrveranstaltung("BWL Vorlesung", 5, 1, false, 0, 0);
        Lehrveranstaltung bwlUeb = new Lehrveranstaltung("BWL Uebung", 0, 1, false, 0, 0);

        Modul mathe1 = new Modul("Mathe1", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(mathe1Vorl, mathe1Ueb), "WiSe", 1);
        Modul prog1 = new Modul("Programmieren1", 7, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(prog1Prak, prog1Vorl), "WiSe", 1);
        Modul eges = new Modul("Eges", 8, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(egesPrak, egesVorl), "WiSe", 1);
        Modul medieninfo = new Modul("Medieninformatik", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(miPrak, miVorl), "WiSe", 1);
        Modul bwl = new Modul("Bwl", 5, false, 0, Arrays.asList(""), Arrays.asList(""), Arrays.asList(bwlUeb, bwlVorl),
                "WiSe", 1);

        ObservableList<Modul> module = FXCollections.observableArrayList();
        module.addAll(mathe1,prog1,eges,medieninfo,bwl);

        Semester erstesSemester = new Semester(1, 30, false,module);

        //2.Sem
        Lehrveranstaltung adsVorl = new Lehrveranstaltung("ADS Vorlesung", 3, 2, false, 0, 0);
        Lehrveranstaltung adsPrak = new Lehrveranstaltung("ADS Praktikum", 2, 2, false, 0, 0);
        Lehrveranstaltung prog2Vorl = new Lehrveranstaltung("Prog2 Vorlesung", 3, 2, false, 0, 0);
        Lehrveranstaltung prog2Prak = new Lehrveranstaltung("Prog2 Praktikum", 2, 2, false, 0, 0);
        Lehrveranstaltung azsVorl = new Lehrveranstaltung("AZS Vorlesung", 3, 2, false, 0, 0);
        Lehrveranstaltung azsPrak = new Lehrveranstaltung("AZS Praktikum", 2, 2, false, 0, 0);
        Lehrveranstaltung mathe2Vorl = new Lehrveranstaltung("Mathe2 Vorlesung", 5, 2, false, 0, 0);
        Lehrveranstaltung mathe2Ueb = new Lehrveranstaltung("Mathe2 Übung", 0, 2, false, 0, 0);
        Lehrveranstaltung gemVorl = new Lehrveranstaltung("GEM Vorlesung", 3, 2, false, 0, 0);
        Lehrveranstaltung gemUeb = new Lehrveranstaltung("GEM Übung", 2, 2, false, 0, 0);
        Lehrveranstaltung rechtVorl = new Lehrveranstaltung("Recht Vorlesung", 5, 2, false, 0, 0);
        Lehrveranstaltung rechtUeb = new Lehrveranstaltung("Recht Übung", 0, 2, false, 0, 0);

        Modul ads = new Modul("ADS", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(adsVorl, adsPrak), "SoSe", 2);
        Modul prog2 = new Modul("Prog 2", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(prog2Vorl, prog2Prak), "SoSe", 2);
        Modul azs = new Modul("AZS", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(azsVorl, azsPrak), "SoSe", 2);
        Modul mathe2 = new Modul("Mathe 2", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(mathe2Vorl, mathe2Ueb), "SoSe", 2);
        Modul gem = new Modul("GEM", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(gemVorl, gemUeb), "SoSe", 2);
        Modul recht = new Modul("Recht", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(rechtVorl, rechtUeb), "SoSe", 2);

        module.clear();
        module.addAll(ads,prog2,azs,mathe2,gem,recht);
        
        Semester zweitesSemester = new Semester(2, 30, false, module);

        //3.Sem
        Lehrveranstaltung datenbankVorl = new Lehrveranstaltung("Datenbanken Vorlesung", 3, 3, false, 0, 0);
        Lehrveranstaltung datenbankPrak = new Lehrveranstaltung("Datenbanken Praktikum", 3, 3, false, 0, 0);
        Lehrveranstaltung prog3Vorl = new Lehrveranstaltung("Prog3 Vorlesung", 3, 3, false, 0, 0);
        Lehrveranstaltung prog3Prak = new Lehrveranstaltung("Prog3 Praktikum", 3, 3, false, 0, 0);
        Lehrveranstaltung eiboVorl = new Lehrveranstaltung("Eibo Vorlesung", 3, 3, false, 0, 0);
        Lehrveranstaltung eiboPrak = new Lehrveranstaltung("Eibo Praktikum", 3, 3, false, 0, 0);
        Lehrveranstaltung afsVorl = new Lehrveranstaltung("AFS Vorlesung", 6, 3, false, 0, 0);
        Lehrveranstaltung afsUeb = new Lehrveranstaltung("AFS Übung", 0, 3, false, 0, 0);
        Lehrveranstaltung mathe3Vorl = new Lehrveranstaltung("Mathe3 Vorlesung", 6, 3, false, 0, 0);
        Lehrveranstaltung mathe3Ueb = new Lehrveranstaltung("Mathe3 Übung", 0, 3, false, 0, 0);

        Modul datenbank = new Modul("Datenbanken", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(datenbankVorl, datenbankPrak), "WiSe", 3);
        Modul prog3 = new Modul("Prog3", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(prog3Vorl, prog3Prak), "WiSe", 3);
        Modul eibo = new Modul("Eibo", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(eiboVorl, eiboPrak), "WiSe", 3);
        Modul afs = new Modul("AFS", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(afsVorl, afsUeb), "WiSe", 3);
        Modul mathe3 = new Modul("mathe3", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(mathe3Vorl, mathe3Ueb), "WiSe", 3);

        module.clear();
        module.addAll(datenbank,prog3,eibo,afs,mathe3);

        Semester drittesSemester = new Semester(3,30,false,module);

        //4.Sem
        Lehrveranstaltung swtVorl = new Lehrveranstaltung("Swt Vorlesung", 3, 4, false, 0, 0);
        Lehrveranstaltung swtPrak = new Lehrveranstaltung("Swt Praktikum", 3, 4, false, 0, 0);
        Lehrveranstaltung webVorl = new Lehrveranstaltung("Web Vorlesung", 3, 4, false, 0, 0);
        Lehrveranstaltung webPrak = new Lehrveranstaltung("Web Praktikum", 3, 4, false, 0, 0);
        Lehrveranstaltung animationVorl = new Lehrveranstaltung("Animation Vorlesung", 3, 4, false, 0, 0);
        Lehrveranstaltung animationPrak = new Lehrveranstaltung("Animation Praktikum", 3, 4, false, 0, 0);
        Lehrveranstaltung cgVorl = new Lehrveranstaltung("CG Vorlesung", 3, 4, false, 0, 0);
        Lehrveranstaltung cgPrak = new Lehrveranstaltung("CG Praktikum", 3, 4, false, 0, 0);
        Lehrveranstaltung rechnerneztVorl = new Lehrveranstaltung("Rechnernetze Vorlesung", 3, 4, false, 0, 0);
        Lehrveranstaltung rechnernetzPrak = new Lehrveranstaltung("Rechnernetze Praktikum", 3, 4, false, 0, 0);

        Modul swt = new Modul("Softwaretechnik", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(swtVorl, swtPrak), "SoSe", 4);
        Modul web = new Modul("Webanwendungen", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(webVorl, webPrak), "SoSe", 4);
        Modul animation = new Modul("Animation", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(animationVorl, animationPrak), "SoSe", 4);
        Modul cg = new Modul("Computergrafik", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(cgVorl, cgPrak), "SoSe", 4);
        Modul rechnernetz = new Modul("Rechnernetze", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(rechnerneztVorl, rechnernetzPrak), "SoSe", 4);

        module.clear();
        module.addAll(swt,web,animation,cg,rechnernetz);

        Semester viertesSemester = new Semester(4, 30, false, module);        

        //5.Sem
        Lehrveranstaltung swtprojVorl = new Lehrveranstaltung("Swtprojekt Vorlesung", 5, 5, false, 0, 0);
        Lehrveranstaltung swtprojPrak = new Lehrveranstaltung("Swtprojekt Praktikum", 5, 5, false, 0, 0);
        Lehrveranstaltung mciVorl = new Lehrveranstaltung("mci Vorlesung", 3, 5, false, 0, 0);
        Lehrveranstaltung mciPrak = new Lehrveranstaltung("mci Praktikum", 3, 5, false, 0, 0);
        Lehrveranstaltung wpGrVorl = new Lehrveranstaltung("Wp gross Vorlesung", 5, 5, false, 0, 0);
        Lehrveranstaltung wpGrPrak = new Lehrveranstaltung("Wp gross Praktikum", 5, 5, false, 0, 0);
        Lehrveranstaltung wpKlVorl = new Lehrveranstaltung("Wp klein Vorlesung", 3, 5, false, 0, 0);
        Lehrveranstaltung wpKlPrak = new Lehrveranstaltung("Wp klein Praktikum", 2, 5, false, 0, 0);

        Modul swtproj = new Modul("Softwaretechnik Projekt", 10, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(swtprojVorl, swtprojPrak), "WiSe", 5);
        Modul mci = new Modul("Mensch Computer Interaktion", 6, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(mciVorl, mciPrak), "WiSe", 5);
        Modul wpGr = new Modul("Wp gross", 10, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(wpGrVorl, wpGrPrak), "immer", 5);
        Modul wpKl = new Modul("Wp klein", 5, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(wpKlVorl, wpKlPrak), "immer", 5);

        module.clear();
        module.addAll(swtproj,mci,wpGr,wpKl);

        Semester fuenftesSemester = new Semester(5, 31, false, module);

        //6.Sem
        Lehrveranstaltung berufspraktlehr = new Lehrveranstaltung("Berufspraktikum", 30, 6, false, 0, 0);
        Modul berufspraktmod = new Modul("Berufspraktikum", 30, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(berufspraktlehr), "immer", 6);

        module.clear();
        module.addAll(berufspraktmod);

        Semester sechstesSemester = new Semester(6, 30, false, module);

        //7.Sem
        Lehrveranstaltung internationalVorl = new Lehrveranstaltung("Internationalisierung Vorlesung", 4, 7, false, 0, 0);
        Lehrveranstaltung ineternationalUeb = new Lehrveranstaltung("Internationalisierung Übung", 0, 7, false, 0, 0);
        Lehrveranstaltung portfolioVorl = new Lehrveranstaltung("Portfolio Vorlesung", 5, 7, false, 0, 0);
        Lehrveranstaltung portfolioPrak = new Lehrveranstaltung("Protfolio Praktikum", 5, 7, false, 0, 0);
        Lehrveranstaltung thesisLehr = new Lehrveranstaltung("Bachelor-Thesis", 15, 7, false, 0, 0);

        Modul international = new Modul("Internationalisierung", 4, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(internationalVorl, ineternationalUeb), "immer", 7);
        Modul portfolio = new Modul("Portfolio", 10, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(portfolioVorl, portfolioPrak), "immer", 7);
        Modul thesis = new Modul("Bachelor-Thesis", 15, false, 0, Arrays.asList(""), Arrays.asList(""),
                Arrays.asList(thesisLehr), "immer", 7);

        module.clear();
        module.addAll(international,portfolio,thesis);

        Semester siebtesSemester = new Semester(7, 29, false, module);

        Studiengang medieninformatik = new Studiengang("Medieninformatik", 180, 7, "Darfst den Gong hauen",
                Arrays.asList(erstesSemester,zweitesSemester,drittesSemester,viertesSemester,fuenftesSemester,sechstesSemester,siebtesSemester), 3, 17, Arrays.asList(""));
        return medieninformatik;
    }

}
