package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.database.ChordsDao;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesList;
import com.sda.javagda40.UltraGuitartron3000.utils.PressEnterKeyToContinue;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppUGT {
    private static final Scanner SCANNER = new Scanner(System.in);
     static final String EXIT = "X";

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        ChordsDao chordsDao = new ChordsDao();
        chordsDao.fillingChords();

        System.out.println("Lista prym do wyboru: "
                + NotesList.getNotesList().subList(0, NotesList.getNotesList().size() / 2));
        List<String> chordNamesList = chordsDao.findChordNames();
        System.out.println(chordNamesList);

//        addingChords(chordsDAO);
        System.out.println("Podaj " + EXIT + " aby zakończyć aplikację.");
        String firstStep = NotesList.choosingRootNote(SCANNER);
//        String chhosenChordType = choosingChordType(chordNamesList);
    }

    //           logika do szukania akordu po nazwie
    private static Chords findingChord(String chordTypeChoice) {
        ChordsDao chordDao = new ChordsDao();
        Optional<Chords> optionalChords = chordDao.findByChordName(chordTypeChoice);
        if (optionalChords.isPresent()) {
            Chords chord = optionalChords.get();
            return chord;
        }
        return null;
    }
}