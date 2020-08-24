package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import java.util.*;

public class ChordsHandler {

    private final Scanner SCANNER;
    private final ChordsController CHORDS_CONTROLLER = new ChordsController();
    private final EntityDao<Chords> CHORDS_ENTITY_DAO = new EntityDao<>();
    private final ChordsDao CHORDS_DAO = new ChordsDao();
    private final Trainee TRAINEE;

    public ChordsHandler(Scanner SCANNER, Trainee trainee) {
        this.SCANNER = SCANNER;
        TRAINEE = trainee;
    }

    public void handle() {
        boolean state = true;
        String chordTypeChoice;
        Optional<Chords> byChordName;
        if (TRAINEE.isAdminPermission())
            adminChordHandler(state);
        else
            nonAdminChordHandler(state);
    }

    private void adminChordHandler(boolean state) {
        Optional<Chords> byChordName;
        String chordTypeChoice;
        do {
            System.out.println(
                    "------------------------------\n" +
                            "|        +A K O R D Y+       |\n" +
                            "|      1.Znajdź akord        |\n" +
                            "|      2.Ćwicz akord         |\n" +
                            "|      3.Wypisz stopnie      |\n" +
                            "|      4.Dodaj akord         |\n" +
                            "|      5.Usuń akord          |\n" +
                            "|      0.Powrót              |\n" +
                            "|                            |\n" +
                            "------------------------------\n");
            int select;
            try {
                select = Integer.parseInt(SCANNER.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                continue;
            }
            switch (select) {
                case 0:
                    state = false;
                    break;
                case 1:
                    System.out.println("Podaj prymę tego akordu: ");
                    String rootNote = Notes.choosingRootNote(SCANNER);
                    System.out.println("Jaki akord chcesz znaleźć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = CHORDS_DAO.findByChordName(chordTypeChoice);
                    System.out.println(CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, rootNote));
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 2:
                    String randomRootNote = Notes.rootNoteRandomizer();
                    System.out.println("Pryma, jaką bedziesz ćwiczyć, to: " + randomRootNote);
                    System.out.println("Jaki akord chcesz ćwiczyć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = CHORDS_DAO.findByChordName(chordTypeChoice);
                    List<String> listOfNotes = CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, randomRootNote);
                    chordTest(SCANNER, listOfNotes);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 3:
                    List<Chords> allChords = CHORDS_ENTITY_DAO.findAll(Chords.class);
                    printingChords(allChords);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 4:
                    System.out.println("Teraz zostanie dodany akord.");
                    CHORDS_CONTROLLER.addChord(CHORDS_ENTITY_DAO, SCANNER);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 5:
                    System.out.println("Podaj akord do usunięcia: ");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = CHORDS_DAO.findByChordName(chordTypeChoice);
                    CHORDS_DAO.delete(byChordName.get().getId());
                    System.out.println("Akord został usunięty.");
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                default:
                    System.out.println("Zotał dokonany błędny wybór.\nSpróbuj ponownie.");
                    break;
            }
        } while (state);
    }

    private void nonAdminChordHandler(boolean state) {
        Optional<Chords> byChordName;
        String chordTypeChoice;
        do {
            System.out.println(
                    "------------------------------\n" +
                            "|        +A K O R D Y+       |\n" +
                            "|      1.Znajdź akord        |\n" +
                            "|      2.Ćwicz akord         |\n" +
                            "|      3.Wypisz stopnie      |\n" +
                            "|      4.Dodaj akord         |\n" +
                            "|      5.Usuń akord          |\n" +
                            "|      0.Powrót              |\n" +
                            "|                            |\n" +
                            "------------------------------\n");
            int select;
            try {
                select = Integer.parseInt(SCANNER.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Niewłaściwy wybór, wybierz jeszcze raz!");
                continue;
            }
            switch (select) {
                case 0:
                    state = false;
                    break;
                case 1:
                    System.out.println("Podaj prymę tego akordu: ");
                    String rootNote = Notes.choosingRootNote(SCANNER);
                    System.out.println("Jaki akord chcesz znaleźć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = CHORDS_DAO.findByChordName(chordTypeChoice);
                    System.out.println(CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, rootNote));
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 2:
                    String randomRootNote = Notes.rootNoteRandomizer();
                    System.out.println("Pryma, jaką bedziesz ćwiczyć, to: " + randomRootNote);
                    System.out.println("Jaki akord chcesz ćwiczyć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = CHORDS_DAO.findByChordName(chordTypeChoice);
                    List<String> listOfNotes = CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, randomRootNote);
                    chordTest(SCANNER, listOfNotes);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 3:
                    List<Chords> allChords = CHORDS_ENTITY_DAO.findAll(Chords.class);
                    printingChords(allChords);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 4:
                case 5:
                    System.err.println("Potrzebujesz uprawnień administratora, aby tego dokonać.");
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                default:
                    System.out.println("Zotał dokonany błędny wybór.\nSpróbuj ponownie.");
                    break;
            }
        } while (state);
    }

    private void printingChords(List<Chords> allChords) {
        for (Chords chord : allChords) {
            System.out.println(chord.getChordName() + ": " +
                    (chord.getFirstNote() + 1) + ", " +
                    (chord.getSecondNote() + 1) + ", " +
                    (chord.getThirdNote() + 1) + ", " +
                    (chord.getFourthNote() + 1));
        }
    }

    private void chordTest(Scanner SCANNER, List<String> notesList) {
        int wynik = 0;
        List<String> testedNotes = new ArrayList<>();
        for (String note : notesList) {
            int noteIndex = notesList.indexOf(note) + 1;
            System.out.println("Podaj " + noteIndex + " dźwięk tego akordu.");
            String testValue = SCANNER.nextLine();
            testedNotes.add(testValue);
        }
        System.out.println(notesList);
        System.out.println(testedNotes);
        for (int i = 0; i < notesList.size(); i++) {
            if (testedNotes.get(i).equalsIgnoreCase(notesList.get(i))) {
                wynik++;
            }
        }
        System.out.print("WYNIK: " + wynik + "/" + notesList.size());
        if (wynik == notesList.size())
            System.out.println(" 👌");
        else
            System.out.println(" 👎");
    }
}
