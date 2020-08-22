package com.sda.javagda40.UltraGuitartron3000.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotesList {
    public static final List<String> notesList = new ArrayList<>
            (Arrays.asList(
//                    wartości powtórzone, żeby  przy wybraniu prymy pod koniec oktawy nie trzeba było przekształcać ani przepisywać.
                    "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B",
                    "C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B"));

    public static List<String> getNotesList() {
        return notesList;
    }
}
