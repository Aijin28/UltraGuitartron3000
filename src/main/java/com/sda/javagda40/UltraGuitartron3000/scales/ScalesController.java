package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.database.HibernateFactory;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScalesController {

    public List<String> gettingScaleFromArray(Optional<Scales> optionalScales, String choice) {
        List<String> chosenScale = new ArrayList<>();
        if (optionalScales.isPresent()) {
            Scales scales = optionalScales.get();
            List<String> notesArray = NotesList.getNotesList();
            int zmienna = notesArray.indexOf(choice);
            chosenScale.add(notesArray.get(scales.getFirstNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getSecondNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getThirdNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getFourthNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getFifthNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getSixthNote() + zmienna));
            chosenScale.add(notesArray.get(scales.getSeventhNote() + zmienna));
        } else System.out.println("Nie ma takiej skali.");
        return chosenScale;
    }
}