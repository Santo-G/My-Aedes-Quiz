package com.androidapp.myaedesquiz.model;

import android.util.Pair;
import com.androidapp.myaedesquiz.R;

import java.util.ArrayList;

public class MainActivityModelImpl implements MainActivityModel {

    public Pair<Integer, String> getCity() {
        ArrayList<Pair<Integer, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<Integer, String>(R.drawable.amsterdam, "amsterdam"));
        arrayList.add(new Pair<Integer, String>(R.drawable.roma, "roma"));
        arrayList.add(new Pair<Integer, String>(R.drawable.parigi, "parigi"));
        arrayList.add(new Pair<Integer, String>(R.drawable.londra, "londra"));
        return arrayList.get((int) (Math.random() * arrayList.size()));
    }

}
