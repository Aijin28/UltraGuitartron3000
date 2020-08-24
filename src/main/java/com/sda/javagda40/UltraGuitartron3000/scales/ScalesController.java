package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScalesController {

    public List<String> gettingScaleFromArray(Optional<Scales> optionalScales, String choice) {
        List<String> chosenScale = new ArrayList<>();
        List<String> notesArray = Notes.getNotesList();
        int zmienna = notesArray.indexOf(choice);
        if (optionalScales.isPresent()) {
            Scales scales = optionalScales.get();
//            nie wiem dlaczego, ale jak dałem + 1 to działa xD
            chosenScale.add(notesArray.get(scales.getFirstNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSecondNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getThirdNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getFourthNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getFifthNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSixthNote() + 1 + zmienna));
            chosenScale.add(notesArray.get(scales.getSeventhNote() + 1 + zmienna));
        } else System.out.println("Nie ma takiej skali.");
        return chosenScale;
    }
}