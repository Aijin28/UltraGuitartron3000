package com.sda.javagda40.UltraGuitartron3000.chords;

import com.sda.javagda40.UltraGuitartron3000.utils.Trainee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "counting_chords")
public class CountingChords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_practised")
    private int timePractised;

    @Column(name = "time_practised_successfully")
    private int timePractisedSuccessfully;

    @OneToMany(mappedBy = "countingChords", fetch = FetchType.LAZY)
    private List<Chords> chords;

    @ManyToOne
    private Trainee trainee;

    public CountingChords() {
    }
}
