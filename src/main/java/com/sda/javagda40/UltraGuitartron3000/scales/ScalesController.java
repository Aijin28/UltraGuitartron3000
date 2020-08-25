package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScalesController {

    public List<String> gettingScaleFromArray(Optional<Scales> optionalScales, String choice) {
        List<String> chosenScale = new ArrayList<>();
        List<String> notesArray = Notes.getNotesList();
        int rootNoteIndex = notesArray.indexOf(choice.toUpperCase());
        if (optionalScales.isPresent()) {
            Scales scales = optionalScales.get();
//            nie wiem dlaczego, ale jak dałem + 1 to działa xD
            chosenScale.add(notesArray.get(scales.getFirstNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getSecondNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getThirdNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getFourthNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getFifthNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getSixthNote()  + rootNoteIndex));
            chosenScale.add(notesArray.get(scales.getSeventhNote()  + rootNoteIndex));
        } else System.out.println("Nie ma takiej skali.");
        return chosenScale;
    }
}