package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.database.HibernateFactory;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScalesController {
    private static final SessionFactory factory = new HibernateFactory().getSessionFactory();

    public List<String> gettingScaleFromArray(Optional<Scales> optionalScales, String choice) {
        List<String> chosenScale = new ArrayList<>();
        if (optionalScales.isPresent()) {
            Scales scales = optionalScales.get();
            List<String> notesArray = NotesList.getNotesList();
            int zmienna = notesArray.indexOf(choice);
//            -1 wykorzystane, ponieważ listy indexuje się od 0, a chciałem zachować prawidłową numerację stopni w akordach
            chosenScale.add(notesArray.get(scales.getFirstNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSecondNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getThirdNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getFourthNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getFifthNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSixthNote() -1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSeventhNote() -1 + zmienna));
            return chosenScale;
        } else System.out.println("Nie ma takiej skali.");
        return null;
    }
}