package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.filling.FillingDB;

import java.util.Optional;

public class AppUGT {

    public static void main(String[] args) {
        try {
//            FillingDB.fillingNotes();
//            FillingDB.fillingChords();
            EntityDao<Chords> chordsDAO = new EntityDao<>();
            Optional<Chords> chordById = chordsDAO.findById(Chords.class, 4);
            System.out.println(chordById);
            String choice = "B";
            System.out.println(ChordsController.gettingChordFromArray(chordById, choice));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Wake up");
        }
    }
}
