package com.sda.javagda40.UltraGuitartron3000.utils;

import java.util.*;

public class NotesList {
    private static final Random RANDOM = new Random();
    public static final List<String> notesList = new ArrayList<>
            (Arrays.asList(
//                    wartości powtórzone, żeby  przy wybraniu prymy pod koniec oktawy nie trzeba było przekształcać ani przepisywać.
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B",
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));

    public static List<String> getNotesList() {
        return notesList;
    }

    public static String choosingRootNote(Scanner SCANNER) {
        System.out.println("Lista prym do wyboru: "
                + notesList.subList(0, NotesList.getNotesList().size() / 2));
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


    public static String rootNoteRandomizer() {
        int random = RANDOM.nextInt(NotesList.getNotesList().size());
        return NotesList.getNotesList().get(random);
    }

}
