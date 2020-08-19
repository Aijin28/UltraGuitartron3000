package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.utils.Notes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "scales")
public class Scales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "scale_name")
    private String scaleName;

    @Column(name = "first_note")
    private int firstNote;

    @Column(name = "second_note")
    private int secondNote;

    @Column(name = "third_note")
    private int thirdNote;

    @Column(name = "fourth_note")
    private int fourthNote;

    @Column(name = "fifth_note")
    private int fifthNote;

    @Column(name = "sixth_note")
    private int sixthNote;

    @Column(name = "seventh_note")
    private int seventhNote;

    @OneToMany(mappedBy = "scales", fetch = FetchType.LAZY)
    private List<Notes> notes;

    @ManyToOne
    private CountingScales countingScales;


    public Scales(String scaleName, int firstNote, int secondNote, int thirdNote, int fourthNote, int fifthNote, int sixthNote, int seventhNote, CountingScales countingScales) {
        this.scaleName = scaleName;
        this.firstNote = firstNote;
        this.secondNote = secondNote;
        this.thirdNote = thirdNote;
        this.fourthNote = fourthNote;
        this.fifthNote = fifthNote;
        this.sixthNote = sixthNote;
        this.seventhNote = seventhNote;
        this.countingScales = countingScales;
    }

    public Scales() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public int getFirstNote() {
        return firstNote;
    }

    public void setFirstNote(int firstNote) {
        this.firstNote = firstNote;
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

    public int getFifthNote() {
        return fifthNote;
    }

    public void setFifthNote(int fifthNote) {
        this.fifthNote = fifthNote;
    }

    public int getSixthNote() {
        return sixthNote;
    }

    public void setSixthNote(int sixthNote) {
        this.sixthNote = sixthNote;
    }

    public int getSeventhNote() {
        return seventhNote;
    }

    public void setSeventhNote(int seventhNote) {
        this.seventhNote = seventhNote;
    }

    public CountingScales getCountingScales() {
        return countingScales;
    }

    public void setCountingScales(CountingScales countingScales) {
        this.countingScales = countingScales;
    }
}
