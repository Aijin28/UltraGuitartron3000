package com.sda.javagda40.UltraGuitartron3000.chords;


import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.database.HibernateFactory;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ChordsController {

    public static List<String> gettingChordWithNotes(Chords chord, String choice) {
        List<String> chosenChord = new ArrayList<>();
        List<String> notesArray = NotesList.getNotesList();
        int firstNoteIndex = notesArray.indexOf(choice.toUpperCase());
//            -1 wykorzystane, ponieważ listy indexuje się od 0, a chciałem zachować prawidłową numerację stopni w akordach
        chosenChord.add(notesArray.get(chord.getFirstNote() - 1 + firstNoteIndex));
        chosenChord.add(notesArray.get(chord.getSecondNote() - 1 + firstNoteIndex));
        chosenChord.add(notesArray.get(chord.getThirdNote() - 1 + firstNoteIndex));
        chosenChord.add(notesArray.get(chord.getFourthNote() - 1 + firstNoteIndex));
        return chosenChord;
    }

    public static void addChord(EntityDao<Chords> chordsEntityDao, Scanner SCANNER) {
        Chords newlyCreated = null;
        do {
            System.out.println("Podaj nazwę akordu: ");
            String name = SCANNER.nextLine();
            try {
                System.out.println("Podaj pierwszą pozycję akordu: ");
                int firstNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj drugą pozycję akordu: ");
                int secondNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj trzecią pozycję akordu: ");
                int thirdNote = Integer.parseInt(SCANNER.nextLine());
                System.out.println("Podaj czwartą pozycję akordu: ");
                int fourthNote = Integer.parseInt(SCANNER.nextLine());
                newlyCreated = new Chords(name, firstNote, secondNote, thirdNote, fourthNote);
                chordsEntityDao.saveOrUpdate(newlyCreated);
                System.out.println("dodano akord: " + name);
            } catch (InputMismatchException ime) {
                System.out.println("Niewłaściwy zapis, wprowadź wartości jeszcze raz");
            }
        } while (newlyCreated == null || newlyCreated.getId() == null);
    }

    public static String choosingChordType(Scanner SCANNER) {
        ChordsDao chordsDao = new ChordsDao();
        System.out.println("Wybierz rodzaj akordu: ");
        String chordTypeChoice = SCANNER.nextLine();
        List<String> chordNameList = chordsDao.findChordNames();
        boolean state = true;
        do {
            if (!chordNameList.contains(chordTypeChoice.toLowerCase())) {
                System.out.println("Został podany błędny akord.");
                chordTypeChoice = SCANNER.nextLine();
            } else if (chordNameList.contains(chordTypeChoice.toLowerCase()))
                state = false;
        } while (!state);
        return chordTypeChoice;
    }

}
