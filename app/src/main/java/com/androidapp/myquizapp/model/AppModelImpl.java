package com.androidapp.myquizapp.model;

import android.util.Pair;
import com.androidapp.myquizapp.R;

import java.util.ArrayList;

public class AppModelImpl implements AppModel {

    public Pair<Integer, String> getCity() {
        ArrayList<Pair<Integer, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<Integer, String>(R.drawable.amsterdam, "amsterdam"));
        arrayList.add(new Pair<Integer, String>(R.drawable.rome, "roma"));
        arrayList.add(new Pair<Integer, String>(R.drawable.paris, "parigi"));
        arrayList.add(new Pair<Integer, String>(R.drawable.london, "londra"));
        return arrayList.get((int) (Math.random() * arrayList.size()));
    }

}
