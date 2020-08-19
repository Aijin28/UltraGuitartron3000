package com.sda.javagda40.UltraGuitartron3000.utils;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;

    @ManyToOne
    private Chords chords;


    public Notes() {
    }

    public Chords getChords() {
        return chords;
    }

    public void setChords(Chords chords) {
        this.chords = chords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
