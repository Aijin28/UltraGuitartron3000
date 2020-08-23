package com.sda.javagda40.UltraGuitartron3000.utils;

import java.util.*;

public class NotesList {
    public static final List<String> notesList = new ArrayList<>
            (Arrays.asList(
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B",
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));

    public static List<String> getNotesList() {
        return notesList;
    }

    private static final Random RANDOM = new Random();

    public static String choosingRootNote(Scanner SCANNER) {
        System.out.println("Lista prym do wyboru: " + notesList.subList(0, NotesList.getNotesList().size() / 2));
        System.out.println("Wybierz prymę: ");
        String rootNoteChoice = SCANNER.nextLine();
        boolean state = true;
        do {
            if (!NotesList.getNotesList().contains(rootNoteChoice.toUpperCase())) {
                System.out.println("Została podana błędna pryma.");
                rootNoteChoice = SCANNER.nextLine();
            } else if (NotesList.getNotesList().contains(rootNoteChoice.toUpperCase())) {
                state = false;
            }
        } while (state);
        return rootNoteChoice;
    }

    public static String rootNoteRandomizer() {
        int random = RANDOM.nextInt(NotesList.getNotesList().size());
        return NotesList.getNotesList().get(random);
    }
}
