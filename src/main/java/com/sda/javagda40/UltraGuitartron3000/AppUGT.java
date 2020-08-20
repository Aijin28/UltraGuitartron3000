package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.filling.FillingDB;

import java.util.Optional;

public class AppUGT {

    public static void main(String[] args) {
//            FillingDB.fillingNotes();
//            FillingDB.fillingChords();
//            FillingDb.fillingScales();
        EntityDao<Chords> chordsDAO = new EntityDao<>();
        Optional<Chords> chordById = chordsDAO.findById(Chords.class, 4);
        System.out.println(chordById);
        String choice = "B";
        System.out.println(ChordsController.gettingChordFromArray(chordById, choice));
        Chords papiezowa = new Chords("papieżowa", 2, 1, 3, 7);
        chordsDAO.saveOrUpdate(papiezowa);
        System.out.println(chordsDAO.findAll(Chords.class));
        System.out.println("Wake up");
    }
}