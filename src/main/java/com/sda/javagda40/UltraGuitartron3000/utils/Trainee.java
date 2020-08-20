package com.sda.javagda40.UltraGuitartron3000.utils;

import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;
import com.sda.javagda40.UltraGuitartron3000.scales.CountingScales;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @Column(name = "scales_practise")
    private List<CountingScales> countingScalesList;

    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @Column(name = "chords_practise")
    private List<CountingChords> countingChords;

    public Trainee(String name) {
        this.name = name;
    }

    public Trainee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CountingScales> getCountingScalesList() {
        return countingScalesList;
    }

    public void setCountingScalesList(List<CountingScales> countingScalesList) {
        this.countingScalesList = countingScalesList;
    }
}