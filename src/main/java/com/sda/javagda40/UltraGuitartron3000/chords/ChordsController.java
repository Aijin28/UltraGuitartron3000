package com.sda.javagda40.UltraGuitartron3000.chords;


import com.sda.javagda40.UltraGuitartron3000.database.HibernateFactory;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ChordsController {
    private static final SessionFactory factory = new HibernateFactory().getSessionFactory();


    public static List<String> gettingChordFromList(Chords chord, String choice) {
        List<String> chosenChord = new ArrayList<>();
//        if (optionalChord.isPresent()) {
//            Chords chord = optionalChord.get();
            List<String> notesArray = NotesList.getNotesList();
            int firstNoteIndex = notesArray.indexOf(choice.toUpperCase());
//            -1 wykorzystane, ponieważ listy indexuje się od 0, a chciałem zachować prawidłową numerację stopni w akordach
            chosenChord.add(notesArray.get(chord.getFirstNote() -1 + firstNoteIndex));
            chosenChord.add(notesArray.get(chord.getSecondNote() -1 + firstNoteIndex));
            chosenChord.add(notesArray.get(chord.getThirdNote() -1 + firstNoteIndex));
            chosenChord.add(notesArray.get(chord.getFourthNote() -1 + firstNoteIndex));
        return chosenChord;
//        } else System.out.println("Został wybrany akord spoza listy.");
//        return null;
    }
}
