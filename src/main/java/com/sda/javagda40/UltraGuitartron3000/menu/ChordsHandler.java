package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ChordsHandler {

    private final Scanner SCANNER;
    private final ChordsController CHORDS_CONTROLLER = new ChordsController();
    private EntityDao<Chords> chordsEntityDao = new EntityDao<>();
    private ChordsDao chordsDao = new ChordsDao();

    public ChordsHandler(Scanner SCANNER) {
        this.SCANNER = SCANNER;
    }

    public void handle() {
        boolean state = true;
        String chordTypeChoice;
        Optional<Chords> byChordName;
        do {
            System.out.println("Co chcesz zrobić?\n1. Znajdź akord.\n2. Ćwicz akord.\n3. Dodaj akord.\n4. Usuń akord.\n0. Powrót.");
            int decision = Integer.parseInt(SCANNER.nextLine());
            switch (decision) {
                case 0:
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    state = false;
                    break;
                case 1:
                    System.out.println("Podaj prymę tego akordu: ");
                    String rootNote = Notes.choosingRootNote(SCANNER);
                    System.out.println("Jaki akord chcesz znaleźć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = chordsDao.findByChordName(chordTypeChoice);
                    System.out.println(CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, rootNote));
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 2:
                    String randomRootNote = Notes.rootNoteRandomizer();
                    System.out.println("Pryma, jaka bedziesz ćwiczyć, to: " + randomRootNote);
                    System.out.println("Jaki akord chcesz ćwiczyć?");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = chordsDao.findByChordName(chordTypeChoice);
                    List<String> listOfNotes = CHORDS_CONTROLLER.gettingChordWithNotes(byChordName, randomRootNote);
                    chordTest(SCANNER, listOfNotes);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 3:
                    System.out.println("Teraz zostanie dodany akord.");
                    CHORDS_CONTROLLER.addChord(chordsEntityDao, SCANNER);
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                case 4:
                    System.out.println("Podaj akord do usunięcia: ");
                    chordTypeChoice = CHORDS_CONTROLLER.choosingChordType(SCANNER);
                    byChordName = chordsDao.findByChordName(chordTypeChoice);
                    chordsDao.delete(byChordName.get().getId());
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    break;
                default:
                    System.out.println("Zotał dokonany błędny wybór.\nSpróbuj jeszcze raz.");
                    break;
            }
        } while (state);
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

        for (int i = 0; i < notesList.size(); i++) {
            if (!testedNotes.get(i).equalsIgnoreCase(notesList.get(i))) {
                System.out.print(testedNotes.get(i) + " 👎 ");
            } else {
                System.out.print(testedNotes.get(i) + " 👍 ");
                wynik++;
            }
        }

        if (wynik == notesList.size())
            System.out.println("👌");
        else
            System.out.println("👎");
    }
}
