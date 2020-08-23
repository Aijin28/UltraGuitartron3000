package com.sda.javagda40.UltraGuitartron3000.utils;

import com.sda.javagda40.UltraGuitartron3000.chords.CountingChords;
import com.sda.javagda40.UltraGuitartron3000.scales.CountingScales;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainee", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private boolean adminPermission;

    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @Column(name = "scales_practise")
    private List<CountingScales> countingScalesList;

    @OneToMany(mappedBy = "trainee", fetch = FetchType.LAZY)
    @Column(name = "chords_practise")
    private List<CountingChords> countingChords;

    public Trainee(String name) {
        this.name = name;
        adminPermission = false;
    }

    public Trainee(String name, boolean adminPermission){
        this.name = name;
        this.adminPermission = adminPermission;
    }

    public Trainee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(boolean adminPermission) {
        this.adminPermission = adminPermission;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", is admin: " + adminPermission;
    }
}