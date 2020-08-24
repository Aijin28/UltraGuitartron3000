package com.sda.javagda40.UltraGuitartron3000.utils;

import java.util.*;

public class Notes {
    public static final List<String> notesList = new ArrayList<>
            (Arrays.asList(

                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B",
                    "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"));
    private static final Random RANDOM = new Random();

    public static List<String> getNotesList() {
        return notesList;
    }

    public static String choosingRootNote(Scanner SCANNER) {
        System.out.println("Lista prym do wyboru: "
                + notesList.subList(0, Notes.getNotesList().size() / 2));
        System.out.println("Wybierz prymę: ");
        String rootNoteChoice = SCANNER.nextLine();
        boolean state = true;
        do {
            if (!Notes.getNotesList().contains(rootNoteChoice.toUpperCase())) {
                System.out.println("Została podana błędna pryma.");
                rootNoteChoice = SCANNER.nextLine();
            } else if (Notes.getNotesList().contains(rootNoteChoice.toUpperCase())) {
                state = false;
            }
        } while (state);
        return rootNoteChoice;
    }

    public static String rootNoteRandomizer() {
        int random = RANDOM.nextInt(Notes.getNotesList().size());
        return Notes.getNotesList().get(random);
    }

    public static int noteInsert(Scanner SCANNER) {
        int note = 0;
        int maxValue = notesList.size() / 2;
        do {
            try {
                note = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Błędna wartość!");
                continue;
            }
            if (note > maxValue) System.out.println("Została podana za duża wartość.");
            if (note < 1) System.out.println("Została podana za mała wartość.");
        } while (note > maxValue || note < 1);
        return note - 1;
    }
}
