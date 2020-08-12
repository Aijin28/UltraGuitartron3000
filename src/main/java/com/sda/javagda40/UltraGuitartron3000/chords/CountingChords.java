package com.sda.javagda40.UltraGuitartron3000.chords;

import javax.persistence.*;

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

}
