package com.example.nikitagamolsky.summitapplication;

import java.util.ArrayList;

/**
 * Created by nikitagamolsky on 8/24/15.
 */
public class Person {
    float confidence;
    int network;
    ArrayList<String> skills;
    int experience;
    boolean job;
    String gotIntoADCS;

    public Person() {
        super();
    }
    public Person(float confidence, int network, ArrayList<String> skills, int experience, boolean job, String gotIntoADCS) {
        this.confidence = confidence;
        this.network = network;
        this.skills = skills;
        this.experience = experience;
        this.job = job;
        this.gotIntoADCS = gotIntoADCS;
    }


}
