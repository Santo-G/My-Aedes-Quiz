package com.androidapp.myaedesquiz.presenter;

import android.util.Pair;
import com.androidapp.myaedesquiz.model.MainActivityModelImpl;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityModelImpl model;
    private static int scores;
    private int pages = 0;

    public MainActivityPresenterImpl() {
        model = new MainActivityModelImpl();
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
