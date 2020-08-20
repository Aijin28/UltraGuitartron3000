//package com.sda.javagda40.UltraGuitartron3000.utils;
//
//import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
//import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
//
//import javax.persistence.*;
//
//@Entity
//public class Notes {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String note;
//    @ManyToOne
//    private Chords chords;
//    @ManyToOne
//    private Scales scales;
//    public Notes(String note) {
//        this.note = note;
//    }
//
//    public Notes() {
//    }
//
//    @Override
//    public String toString() {
//        return "Notes{" +
//                "id=" + id +
//                ", note='" + note + '\'' +
//                '}';
//    }
//
//    public Chords getChords() {
//        return chords;
//    }
//
//    public void setChords(Chords chords) {
//        this.chords = chords;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public Scales getScales() {
//        return scales;
//    }
//
//    public void setScales(Scales scales) {
//        this.scales = scales;
//    }
//}
