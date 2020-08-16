package com.sda.javagda40.UltraGuitartron3000.chords;

import javax.persistence.*;

@Entity
@Table(name = "chords")
public class Chords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chord_name")
    private String chordName;

    @Column(name = "firts_note")
    private int firsNote;
    @Column(name = "second_note")
    private int secondNote;
    @Column(name = "third_note")
    private int thirdNote;
    @Column(name = "fourth_note")
    private int fourthNote;

    @ManyToOne
    private CountingChords countingChords;

    public Chords(String chordName, int firsNote, int secondNote, int thirdNote, int fourthNote, CountingChords countingChords) {
        this.chordName = chordName;
        this.firsNote = firsNote;
        this.secondNote = secondNote;
        this.thirdNote = thirdNote;
        this.fourthNote = fourthNote;
        this.countingChords = countingChords;
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

    public int getFirsNote() {
        return firsNote;
    }

    public void setFirsNote(int firsNote) {
        this.firsNote = firsNote;
    }

    public int getSecondNote() {
        return secondNote;
    }

    public void setSecondNote(int secondNote) {
        this.secondNote = secondNote;
    }

    public int getThirdNote() {
        return thirdNote;
    }

    public void setThirdNote(int thirdNote) {
        this.thirdNote = thirdNote;
    }

    public int getFourthNote() {
        return fourthNote;
    }

    public void setFourthNote(int fourthNote) {
        this.fourthNote = fourthNote;
    }

    public CountingChords getCountingChords() {
        return countingChords;
    }

    public void setCountingChords(CountingChords countingChords) {
        this.countingChords = countingChords;
    }
}
