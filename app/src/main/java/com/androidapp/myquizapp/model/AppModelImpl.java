package com.androidapp.myquizapp.model;

import android.util.Pair;
import com.androidapp.myquizapp.R;

import java.util.ArrayList;

public class AppModelImpl implements AppModel {

    private ArrayList<Pair<Integer, String>> arrayList = new ArrayList<>();

    public AppModelImpl() {
        arrayList.add(new Pair<Integer, String>(R.drawable.amsterdam, "amsterdam"));
        arrayList.add(new Pair<Integer, String>(R.drawable.rome, "rome"));
        arrayList.add(new Pair<Integer, String>(R.drawable.paris, "paris"));
        arrayList.add(new Pair<Integer, String>(R.drawable.london, "london"));
    }

    public Pair<Integer, String> getCity() {
        return arrayList.get((int) (Math.random() * arrayList.size()));
    }

}
