package com.sda.javagda40.UltraGuitartron3000.chords;


import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.*;

public class ChordsController {

    public List<String> gettingChordWithNotes(Optional<Chords> optionalChord, String choice) {
        List<String> chosenChord = new ArrayList<>();
        List<String> notesArray = Notes.getNotesList();
        int rootNoteIndex = notesArray.indexOf(choice.toUpperCase());
        if (optionalChord.isPresent()) {
            Chords chord = optionalChord.get();
            chosenChord.add(notesArray.get(chord.getFirstNote() + rootNoteIndex));
            chosenChord.add(notesArray.get(chord.getSecondNote() + rootNoteIndex));
            chosenChord.add(notesArray.get(chord.getThirdNote() + rootNoteIndex));
            chosenChord.add(notesArray.get(chord.getFourthNote() + rootNoteIndex));
        } else System.out.println("Nie ma takiego akordu.");
        return chosenChord;
    }

    public void addChord(EntityDao<Chords> chordsEntityDao, Scanner SCANNER) {
        Chords newlyCreated = null;
        do {
            System.out.println("Podaj nazwę akordu: ");
            String name = SCANNER.nextLine();
            try {
                System.out.println("Podaj pierwszą pozycję akordu: ");
                int firstNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj drugą pozycję akordu: ");
                int secondNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj trzecią pozycję akordu: ");
                int thirdNote = Notes.noteInsert(SCANNER);
                System.out.println("Podaj czwartą pozycję akordu: ");
                int fourthNote = Notes.noteInsert(SCANNER);
                newlyCreated = new Chords(name, firstNote, secondNote, thirdNote, fourthNote);
                chordsEntityDao.saveOrUpdate(newlyCreated);
                System.out.println("Dodano akord: " + name + " 👌");
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy zapis, wprowadź wartości jeszcze raz");
            }
        } while (newlyCreated == null || newlyCreated.getId() == null);
    }

    public String choosingChordType(Scanner SCANNER) {
        ChordsDao chordsDao = new ChordsDao();
        System.out.println(chordsDao.findChordNames());
        System.out.println("Wybierz rodzaj akordu: ");
        String chordTypeChoice = SCANNER.nextLine();
        List<String> chordNameList = chordsDao.findChordNames();
        boolean state = true;
        do {
            if (!chordNameList.contains(chordTypeChoice)) {
                System.out.println("Został podany błędny akord.");
                chordTypeChoice = SCANNER.nextLine();
            } else {
                state = false;
            }
        } while (state);
        return chordTypeChoice;
    }

    public void deletingChord(Scanner SCANNER, ChordsDao CHORDS_DAO, ChordsController CHORDS_CONTROLLER) {
        System.out.println("Podaj akord do usunięcia: ");
        System.out.println(CHORDS_DAO.findChordNames());
        String chordTypeChoice = SCANNER.nextLine();
        Optional<Chords> byChordName = CHORDS_DAO.findByChordNameToDelete(chordTypeChoice);
        if (byChordName.isPresent()) {
            CHORDS_DAO.delete(byChordName.get().getId());
            System.out.println("Akord został usunięty.");
        } else System.out.println("Nie ma takiego akordu.");
    }
}
