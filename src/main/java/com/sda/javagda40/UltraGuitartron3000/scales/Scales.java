package com.sda.javagda40.UltraGuitartron3000.scales;

import javax.persistence.*;

@Entity
@Table(name = "scales")
public class Scales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String scaleName;

    private int firstNote;

    private int secondNote;

    private int thirdNote;

    private int fourthNote;

    private int fifthNote;

    private int sixthNote;

    private int seventhNote;

    public Scales(String scaleName, int firstNote, int secondNote, int thirdNote, int fourthNote, int fifthNote, int sixthNote, int seventhNote) {
        this.scaleName = scaleName;
        this.firstNote = firstNote;
        this.secondNote = secondNote;
        this.thirdNote = thirdNote;
        this.fourthNote = fourthNote;
        this.fifthNote = fifthNote;
        this.sixthNote = sixthNote;
        this.seventhNote = seventhNote;
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
}
