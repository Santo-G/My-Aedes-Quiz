package com.androidapp.myaedesquiz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import com.androidapp.myaedesquiz.databinding.FragmentHomeBinding;
import com.androidapp.myaedesquiz.databinding.FragmentRequestResponseBinding;
import com.androidapp.myaedesquiz.presenter.MainActivityPresenterImpl;

public class RequestResponseFragment extends Fragment implements View.OnClickListener {

    MainActivityPresenterImpl mainActivityPresenter = new MainActivityPresenterImpl();
    private Pair<Integer, String> city;
    private FragmentRequestResponseBinding binding;

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
        binding.imageviewQuestion.setImageDrawable(getResources().getDrawable(city.first, null));
        binding.romaButton.setOnClickListener(this);
        binding.londraButton.setOnClickListener(this);
        binding.parigiButton.setOnClickListener(this);
        binding.amsterdamButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.roma_button:
                if (city.second.equals("roma"))
                    mainActivityPresenter.countScores(5);
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Risposta corretta:" + city.second, Toast.LENGTH_SHORT).show();
                break;
            case R.id.londra_button:
                if (city.second.equals("londra"))
                    mainActivityPresenter.countScores(5);
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Risposta corretta:" + city.second, Toast.LENGTH_SHORT).show();
                break;

            case R.id.amsterdam_button:
                if (city.second.equals("amsterdam"))
                    mainActivityPresenter.countScores(5);
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Risposta corretta:" + city.second, Toast.LENGTH_SHORT).show();
                break;

            case R.id.parigi_button:
                if (city.second.equals("parigi"))
                    mainActivityPresenter.countScores(5);
                else
                    Toast.makeText(getActivity().getApplicationContext(), "Risposta corretta:" + city.second, Toast.LENGTH_SHORT).show();
                break;
        }

        city = mainActivityPresenter.getRandomCity();

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mainActivityPresenter.getPages() < 4) {
                    binding.imageviewQuestion.setImageDrawable(getResources().getDrawable(city.first, null));
                    binding.questionNumTextview.setText("Page:"+(mainActivityPresenter.getPages()+1)+"/4");
                    binding.scoreTextview.setText("Score: "+mainActivityPresenter.getScores());
                    mainActivityPresenter.setPages();
                } else {
                    Navigation.findNavController(view).navigate(R.id.homeFragment);
                }
            }
        }, 1000);

    }
}
