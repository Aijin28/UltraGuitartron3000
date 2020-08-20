package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.CountingScales;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.filling.FillingDB;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

public class AppUGT {

    public static void main(String[] args) {
//        Notes notes = new Notes();
//        Trainee trainee = new Trainee();
//        CountingScales countingScales = new CountingScales();
//        Scales scales = new Scales();
//        CountingChords countingChords = new CountingChords();
//        ChordsController chordsController = new ChordsController();
//        Chords chords = new Chords();
//        EntityDao dao = new EntityDao<>();
        try {
            FillingDB.fillingNotes();
            FillingDB.fillingChords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
