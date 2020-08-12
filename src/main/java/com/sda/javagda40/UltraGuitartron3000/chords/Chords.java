package com.sda.javagda40.UltraGuitartron3000.chords;

import javax.persistence.*;

@Entity
@Table(name = "chords")
public class Chords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String chordName;

    private int first_note;
    private int second_note;
    private int third_note;
    private int fourth_note;

    public Chords(String chordName, int first_note, int second_note, int third_note, int fourth_note) {
        this.chordName = chordName;
        this.first_note = first_note;
        this.second_note = second_note;
        this.third_note = third_note;
        this.fourth_note = fourth_note;
    }

    public Chords() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChordName() {
        return chordName;
    }

    public void setChordName(String chordName) {
        this.chordName = chordName;
    }

    public int getFirst_note() {
        return first_note;
    }

    public void setFirst_note(int first_note) {
        this.first_note = first_note;
    }

    public int getSecond_note() {
        return second_note;
    }

    public void setSecond_note(int second_note) {
        this.second_note = second_note;
    }

    public int getThird_note() {
        return third_note;
    }

    public void setThird_note(int third_note) {
        this.third_note = third_note;
    }

    public int getFourth_note() {
        return fourth_note;
    }

    public void setFourth_note(int fourth_note) {
        this.fourth_note = fourth_note;
    }
}
