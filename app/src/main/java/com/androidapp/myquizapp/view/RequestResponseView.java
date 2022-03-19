package com.androidapp.myquizapp.view;

import android.util.Pair;
import android.view.View;

public interface RequestResponseView {

    public void updateScoreCount(int points);

    public void showRightAnswerToast(Pair<Integer, String> city);

    public void goHome(View view);

    public void nextQuestion();

}
