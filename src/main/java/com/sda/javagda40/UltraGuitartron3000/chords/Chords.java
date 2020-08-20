package com.sda.javagda40.UltraGuitartron3000.chords;

//import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chords")
public class Chords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chord_name")
    private String chordName;

    @Column(name = "first_note")
    private int firsNote;
    @Column(name = "second_note")
    private int secondNote;
    @Column(name = "third_note")
    private int thirdNote;
    @Column(name = "fourth_note")
    private int fourthNote;
//
//    @OneToMany(mappedBy = "chords", fetch = FetchType.LAZY)
//    private List<Notes> notes;

    @ManyToOne
    private CountingChords countingChords;

    public Chords(String chordName, int firsNote, int secondNote, int thirdNote, int fourthNote) {
        this.chordName = chordName;
        this.firsNote = firsNote;
        this.secondNote = secondNote;
        this.thirdNote = thirdNote;
        this.fourthNote = fourthNote;
    }

    public Chords() {
    }

//    public List<Notes> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(List<Notes> notes) {
//        this.notes = notes;
//    }

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

    @Override
    public String toString() {
        return "chord_name='" + chordName + " - " +
                "firs_note= " + firsNote +
                ", second_note= " + secondNote +
                ", third_note= " + thirdNote +
                ", fourth_note= " + fourthNote;
    }
}
