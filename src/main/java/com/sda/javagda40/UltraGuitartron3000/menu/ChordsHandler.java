package com.sda.javagda40.UltraGuitartron3000.menu;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ChordsHandler {
    private static final Random RANDOM = new Random();
    private final Scanner SCANNER;
    private EntityDao<Chords> chordsEntityDao;
    private ChordsDao chordsDao;

    public ChordsHandler(Scanner SCANNER) {
        this.SCANNER = SCANNER;
    }

    public void handle() {
        System.out.println("Co chcesz zrobić?\n1. Znajdź akord.\n2. Ćwicz akord.\n3. Dodaj akord.\n4. Usuń akord.\n0. Powrót.");
        boolean state = true;
        String chordTypeChoice;
        Chords byChordName;
        do {
            int decision = Integer.parseInt(SCANNER.nextLine());
            switch (decision) {
                case 0:
                    PressEnterKeyToContinue.pressEnterKeyToContinue();
                    state = false;
                    break;
                case 1:
                    System.out.println("Podaj prymę tego akordu: ");
                    String rootNote = NotesList.choosingRootNote(SCANNER);
                    System.out.println("Jaki akord chcesz znaleźć?");
                    chordTypeChoice = ChordsController.choosingChordType(SCANNER);
                    byChordName = chordsDao.findByChordName(chordTypeChoice).get();
                    System.out.println(ChordsController.gettingChordWithNotes(byChordName, rootNote));
                    break;
                case 2:
                    String randomRootNote = rootNoteRandomizer();
                    System.out.println("Pryma, jaka bedziesz ćwiczyć, to: " + randomRootNote);
                    System.out.println("Jaki akord chcesz ćwiczyć?");
                    chordTypeChoice = ChordsController.choosingChordType(SCANNER);
                    byChordName = chordsDao.findByChordName(chordTypeChoice).get();
                    List<String> listOfNotes = ChordsController.gettingChordWithNotes(byChordName, randomRootNote);
                    chordTest(SCANNER, listOfNotes);
                    break;
                case 3:
                    System.out.println("Teraz zostanie dodany akord.");
                    ChordsController.addChord(chordsEntityDao, SCANNER);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Zotał dokonany błędny wybór.\nSpróbuj jeszcze raz.");
                    break;
            }
        } while (state);
    }

    private String rootNoteRandomizer() {
        int random = RANDOM.nextInt(NotesList.getNotesList().size() / 2);
        return NotesList.getNotesList().get(random);
    }

    private void chordTest(Scanner SCANNER, List<String> notesList) {
        int wynik = 0;
        for (String note : notesList) {
            System.out.println("Podaj " + notesList.indexOf(note) + 1 + " dźwięk tego akordu.");
            String testValue = SCANNER.nextLine();
            if (testValue.equalsIgnoreCase(note))
                wynik++;
        }
        if (wynik == 4)
            System.out.println("Gratulacje.");
        else
            System.out.println("Niestety nie udało się.");
    }
}
