package com.sda.javagda40.UltraGuitartron3000.scales;

import javax.persistence.*;

@Entity
@Table(name = "counting_scales")
public class CountingScales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_practised")
    private int timePractised;

    @Column(name = "time_practised_successfully")
    private int timePractisedSuccessfully;
}
