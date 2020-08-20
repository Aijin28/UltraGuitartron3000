package com.sda.javagda40.UltraGuitartron3000.filling;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
//import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

public class FillingDB {

//    public static void fillingNotes() throws InterruptedException {
//        EntityDao<Notes> notesDAO = new EntityDao<>();
//        Notes c = new Notes("C");
//        notesDAO.saveOrUpdate(c);
//        Notes cis = new Notes("C#/Db");
//        notesDAO.saveOrUpdate(cis);
//        Notes d = new Notes("D");
//        notesDAO.saveOrUpdate(d);
//        Notes dis = new Notes("D#/Eb");
//        notesDAO.saveOrUpdate(dis);
//        Notes e = new Notes("E");
//        notesDAO.saveOrUpdate(e);
//        Notes f = new Notes("F");
//        notesDAO.saveOrUpdate(f);
//        Notes fis = new Notes("F#/Gb");
//        notesDAO.saveOrUpdate(fis);
//        Notes g = new Notes("G");
//        notesDAO.saveOrUpdate(g);
//        Notes gis = new Notes("G#/Ab");
//        notesDAO.saveOrUpdate(gis);
//        Notes a = new Notes("A");
//        notesDAO.saveOrUpdate(a);
//        Notes ais = new Notes("A#/Bb");
//        notesDAO.saveOrUpdate(ais);
//        Notes b = new Notes("B");
//        notesDAO.saveOrUpdate(b);
//    }

    public static void fillingChords(){
        EntityDao<Chords> chordsDAO = new EntityDao<>();
        Chords xmaj7 = new Chords("Xmaj7", 1, 5, 8, 12);
        chordsDAO.saveOrUpdate(xmaj7);
        Chords x7 = new Chords("X7", 1, 5, 8, 11);
        chordsDAO.saveOrUpdate(x7);
        Chords xmin7 = new Chords("Xmin7", 1, 4, 8, 11);
        chordsDAO.saveOrUpdate(xmin7);
        Chords xmin75b = new Chords("Xmin7/5b", 1, 4, 7, 11);
        chordsDAO.saveOrUpdate(xmin75b);
    }

    public static void fillingScales(){
        EntityDao<Scales> scalesDAO = new EntityDao<>();
        Scales ionian = new Scales("Jońska",1,3,5,6,8,10,12);
        scalesDAO.saveOrUpdate(ionian);
        Scales dorian = new Scales("Dorycka",1,3,4,6,8,10,11);
        scalesDAO.saveOrUpdate(dorian);
        Scales phrygian = new Scales("Frygijska",1,2,4,6,8,9,11);
        scalesDAO.saveOrUpdate(phrygian);
        Scales lydian = new Scales("Lidyjska",1,3,5,7,8,10,12);
        scalesDAO.saveOrUpdate(lydian);
        Scales mixolydian = new Scales("Miksolidyjska",1,3,5,6,8,10,11);
        scalesDAO.saveOrUpdate(mixolydian);
        Scales aeolian = new Scales("Eolska",1,3,4,6,8,9,11);
        scalesDAO.saveOrUpdate(aeolian);
        Scales locrian = new Scales("Lokrycka",1,2,4,6,8,9,11);
        scalesDAO.saveOrUpdate(locrian);
        Scales harmonicMinor = new Scales("Molowa harmoniczna", 1, 3, 4, 6, 8, 9, 12);
        scalesDAO.saveOrUpdate(harmonicMinor);
        Scales phyrgianDominant = new Scales("Frygijska dominantowa", 1, 2, 5, 6, 8, 9, 11);
        scalesDAO.saveOrUpdate(phyrgianDominant);
    }
}