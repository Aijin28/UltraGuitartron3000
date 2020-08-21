package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.filling.FillingDB;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppUGT {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String EXIT = "X";

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        FillingDB.fillingChords();
        System.out.println("Lista prym do wyboru: " + NotesList.getNotesList().subList(0, NotesList.getNotesList().size() / 2));
        EntityDao<Chords> chordsDAO = new EntityDao<>();
        List<String> chordNameList = new ArrayList<>();
        for (Chords chord : chordsDAO.findAll(Chords.class)) {
            chordNameList.add(chord.getChordName());
        }
        System.out.println("Akordy do wyboru: " + chordNameList);

        addingChords(chordsDAO);
        System.out.println("Podaj " + EXIT + " aby zakończyć aplikację.");
        String firstStep = choosingFirstStep(EXIT);
        String chordTypeChoice = choosingChordType(EXIT, chordNameList);
        findingChord(chordsDAO, firstStep, chordTypeChoice);
    }

    private static String choosingFirstStep(String EXIT) {
        System.out.println("Wybierz prymę: ");
        String primeNoteChoice = SCANNER.nextLine();
        do {
            if (primeNoteChoice.equalsIgnoreCase(EXIT)) {
                System.out.println("Tutaj powinno się zamknąć.");
                PressEnterKeyToContinue.pressEnterKeyToContinue();
                break;
            } else if (!NotesList.getNotesList().contains(primeNoteChoice.toUpperCase())) {
                System.out.println("Została podana błędna pryma.");
                primeNoteChoice = SCANNER.nextLine();
            } else if (NotesList.getNotesList().contains(primeNoteChoice.toUpperCase())) {
                return primeNoteChoice;
            }
        } while (!primeNoteChoice.equalsIgnoreCase(EXIT));
        return primeNoteChoice;
    }

    private static void addingChords(EntityDao<Chords> chordsDao) {
        System.out.println("Podaj nazwę akordu: ");
        String chordName = SCANNER.nextLine();
        System.out.println("Podaj pierwszy stopień akordu: ");
        int firstStep = SCANNER.nextInt();
        System.out.println("Podaj drugi stopień akordu: ");
        int secondStep = SCANNER.nextInt();
        System.out.println("Podaj trzeci stopień akordu: ");
        int thirdStep = SCANNER.nextInt();
        System.out.println("Podaj czwarty stopień akordu: ");
        int fourthStep = SCANNER.nextInt();
        chordsDao.saveOrUpdate(new Chords(chordName, firstStep, secondStep, thirdStep, fourthStep));
    }

    private static String choosingChordType(String EXIT, List<String> chordNameList) {
        System.out.println("Wybierz rodzaj akordu: ");
        String chordTypeChoice = SCANNER.nextLine();
        do {
            if (chordTypeChoice.equalsIgnoreCase(EXIT)) {
                System.out.println("Tutaj powinno się zamknąć.");
                PressEnterKeyToContinue.pressEnterKeyToContinue();
                break;
            } else if (!chordNameList.contains(chordTypeChoice.toLowerCase())) {
                System.out.println("Został podany błędny akord.");
                chordTypeChoice = SCANNER.nextLine();
            } else if (chordNameList.contains(chordTypeChoice.toLowerCase()))
                return chordTypeChoice;
        } while (!chordTypeChoice.equalsIgnoreCase(EXIT));
        return chordTypeChoice;
    }

    private static String choosingScale(String EXIT, List<String> scaleNameList) {
        System.out.println("Wybierz skalę: ");
        String scaleChoice = SCANNER.nextLine();
        do {
            if (scaleChoice.equalsIgnoreCase(EXIT)) {
                System.out.println("Tutaj powinno się zamknąć.");
                PressEnterKeyToContinue.pressEnterKeyToContinue();
                break;
            } else if (!scaleNameList.contains(scaleChoice.toLowerCase())) {
                System.out.println("Został podany błędny akord.");
                scaleChoice = SCANNER.nextLine();
            } else if (scaleNameList.contains(scaleChoice.toLowerCase()))
                return scaleChoice;
        } while (!scaleChoice.equalsIgnoreCase(EXIT));
        return scaleChoice;
    }

    //           logika do szukania akordu po nazwie
    private static void findingChord(EntityDao<Chords> chordsDAO, String primeNoteChoice, String chordTypeChoice) {
        for (Chords chord : chordsDAO.findAll(Chords.class)) {
            if (chord.getChordName().equalsIgnoreCase(chordTypeChoice)) {
                Optional<Chords> optionalChords = chordsDAO.findById(Chords.class, chord.getId());
                optionalChords.ifPresent(chords -> System.out.println(ChordsController.gettingChordFromList(chords, primeNoteChoice)));
            }
        }
    }
}
