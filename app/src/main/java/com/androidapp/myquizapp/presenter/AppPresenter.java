package com.androidapp.myquizapp.presenter;

import android.util.Pair;

public interface AppPresenter {

    Pair<Integer, String> getRandomCity();
    void countScores(int score);
    void setPages();
    int getPages();

}
