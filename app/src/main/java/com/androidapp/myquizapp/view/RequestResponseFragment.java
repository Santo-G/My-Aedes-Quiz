package com.androidapp.myquizapp.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.androidapp.myquizapp.R;
import com.androidapp.myquizapp.databinding.FragmentRequestResponseBinding;
import com.androidapp.myquizapp.presenter.AppPresenterImpl;

public class RequestResponseFragment extends Fragment implements RequestResponseView, View.OnClickListener {

    AppPresenterImpl mainActivityPresenter = new AppPresenterImpl();
    private Pair<Integer, String> city;
    private FragmentRequestResponseBinding binding;
    private int pointForRightanswer = 5;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        city = mainActivityPresenter.getRandomCity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRequestResponseBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.btRome.setBackgroundColor(getResources().getColor(R.color.purple_200));
        binding.btLondon.setBackgroundColor(getResources().getColor(R.color.purple_200));
        binding.btParis.setBackgroundColor(getResources().getColor(R.color.purple_200));
        binding.btAmsterdam.setBackgroundColor(getResources().getColor(R.color.purple_200));

        binding.ivQuestion.setImageDrawable(getResources().getDrawable(city.first, null));
        binding.btRome.setOnClickListener(this);
        binding.btLondon.setOnClickListener(this);
        binding.btParis.setOnClickListener(this);
        binding.btAmsterdam.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_rome:
                if (city.second.equals("rome"))
                    updateScoreCount(pointForRightanswer);
                else
                    showRightAnswerToast(city);
                break;
            case R.id.bt_london:
                if (city.second.equals("london"))
                    updateScoreCount(pointForRightanswer);
                else
                    showRightAnswerToast(city);
                break;

            case R.id.bt_amsterdam:
                if (city.second.equals("amsterdam"))
                    updateScoreCount(pointForRightanswer);
                else
                    showRightAnswerToast(city);
                break;

            case R.id.bt_paris:
                if (city.second.equals("paris"))
                    updateScoreCount(pointForRightanswer);
                else
                    showRightAnswerToast(city);
                break;
        }

        city = mainActivityPresenter.getRandomCity();

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mainActivityPresenter.getPages() < 4) {
                    nextQuestion();
                } else {
                    goHome(view);
                }
            }
        }, 1000);
    }

    public void updateScoreCount(int points){
        mainActivityPresenter.countScores(points);
    }

    public void showRightAnswerToast(Pair<Integer, String> city){
        Toast.makeText(getActivity().getApplicationContext(), "Right answer was: " + city.second, Toast.LENGTH_SHORT).show();
    }

    public void goHome(View view) {
        Navigation.findNavController(view).navigate(R.id.homeFragment);
    }

    public void nextQuestion() {
        binding.ivQuestion.setImageDrawable(getResources().getDrawable(city.first, null));
        binding.tvQuestionNum.setText("Page: " + (mainActivityPresenter.getPages() + 1) + "/4");
        binding.tvScore.setText("Score: " + mainActivityPresenter.getScores());
        mainActivityPresenter.setPages();
    }

}
