package com.sda.javagda40.UltraGuitartron3000.scales;

import com.sda.javagda40.UltraGuitartron3000.trainee.Trainee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "counting_scales")
public class CountingScales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time_practised")
    private int timePractised;

    @Column(name = "time_practised_successfully")
    private int timePractisedSuccessfully;

    @OneToMany(mappedBy = "countingScales", fetch = FetchType.LAZY)
    private List<Scales> scalesList;

    @ManyToOne
    private Trainee trainee;

    public CountingScales() {
    }
}