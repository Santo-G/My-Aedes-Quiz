package com.androidapp.myquizapp.presenter;

import android.util.Pair;
import com.androidapp.myquizapp.model.AppModelImpl;

public class AppPresenterImpl implements AppPresenter {

    private AppModelImpl model;
    private static int scores;
    private int pages = 0;

    public AppPresenterImpl() {
        model = new AppModelImpl();
        scores = 0;
    }

    public Pair<Integer, String> getRandomCity(){
        return model.getCity();
    }

    public void countScores(int score){
        scores+=score;
    }

    public int getScores(){
        return scores;
    }

    public void setPages(){
        pages++;
    }

    public int getPages(){
      return pages;
    }

}
