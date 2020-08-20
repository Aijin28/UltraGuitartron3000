package com.sda.javagda40.UltraGuitartron3000.filling;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.database.EntityDao;
import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

public class FillingDB {

    public static void fillingNotes() throws InterruptedException {
        EntityDao<Notes> notesDAO = new EntityDao<>();
        Notes c = new Notes("C");
        notesDAO.saveOrUpdate(c);
        Notes cis = new Notes("C#");
        notesDAO.saveOrUpdate(cis);
        Notes d = new Notes("D");
        notesDAO.saveOrUpdate(d);
        Notes dis = new Notes("D#");
        notesDAO.saveOrUpdate(dis);
        Notes e = new Notes("E");
        notesDAO.saveOrUpdate(e);
        Notes f = new Notes("F");
        notesDAO.saveOrUpdate(f);
        Notes fis = new Notes("F#");
        notesDAO.saveOrUpdate(fis);
        Notes g = new Notes("G");
        notesDAO.saveOrUpdate(g);
        Notes gis = new Notes("G#");
        notesDAO.saveOrUpdate(gis);
        Notes a = new Notes("A");
        notesDAO.saveOrUpdate(a);
        Notes ais = new Notes("A#");
        notesDAO.saveOrUpdate(ais);
        Notes b = new Notes("B");
        notesDAO.saveOrUpdate(b);
    }

    public static void fillingChords() throws InterruptedException {
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
}
