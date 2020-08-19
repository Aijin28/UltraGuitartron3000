package com.sda.javagda40.UltraGuitartron3000;

import com.sda.javagda40.UltraGuitartron3000.chords.ChordsController;
import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.CountingScales;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;
import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

public class AppUGT {

    public static void main(String[] args) {
        Notes c = new Notes("C");
        Trainee trainee = new Trainee();
        ChordsController chordsController = new ChordsController();
        CountingScales countingScales = new CountingScales();
        Scales scales = new Scales();
        CountingChords countingChords = new CountingChords();
        EntityDao<Notes> appUserEntityDao = new EntityDao<>();
        appUserEntityDao.saveOrUpdate(c);
    }
}
