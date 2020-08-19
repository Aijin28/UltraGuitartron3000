package com.sda.javagda40.UltraGuitartron3000.utils;

import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @Column(name = "chords_practise")
    private List<CountingChords> countingChords;

    public Trainee() {
    }

}
