package com.example.nikitagamolsky.summitapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by nikitagamolsky on 9/2/15.
 */
public class Results {
    Drawable image;
    String text;

    public Results(Drawable image, String text) {
        this.image = image;
        this.text = text;
    }

    public Results() {
        super();
    }
}


