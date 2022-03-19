package com.androidapp.myquizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.Navigation;
import com.androidapp.myquizapp.databinding.FragmentHomeBinding;
import com.androidapp.myquizapp.presenter.MainActivityPresenter;
import com.androidapp.myquizapp.presenter.MainActivityPresenterImpl;
import com.androidapp.myquizapp.view.MainActivityView;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment implements MainActivityView, View.OnClickListener {

    private TextView highscoreTextView;
    private Button startButton;
    private MainActivityPresenter mainActivityPresenter;
    private FragmentHomeBinding binding;


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init
        mainActivityPresenter = new MainActivityPresenterImpl();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.inflate(getContext(), R.layout.fragment_home, binding.getRoot());
        // find view
        highscoreTextView = binding.highscoreTextview;
        startButton = binding.startButton;

        // set listener on start button
        startButton.setOnClickListener(this);

    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.requestResponseFragment);
    }

}
