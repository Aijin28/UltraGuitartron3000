package com.sda.javagda40.UltraGuitartron3000.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NotesList {
    public static final List<String> notesList = new ArrayList<>
            (Arrays.asList(
//                    wartości powtórzone, żeby  przy wybraniu prymy pod koniec oktawy nie trzeba było przekształcać ani przepisywać.
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B",
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));

    public static List<String> getNotesList() {
        return notesList;
    }

    public static String choosingRootNote(Scanner SCANNER) {
        System.out.println("Wybierz prymę: ");
        String primeNoteChoice = SCANNER.nextLine();
        boolean state = true;
        do {
            if (!NotesList.getNotesList().contains(primeNoteChoice.toUpperCase())) {
                System.out.println("Została podana błędna pryma.");
                primeNoteChoice = SCANNER.nextLine();
            } else if (NotesList.getNotesList().contains(primeNoteChoice.toUpperCase())) {
                state = false;
            }
        } while (state);
        return primeNoteChoice;
    }

}
