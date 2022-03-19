package com.androidapp.myquizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.androidapp.myquizapp.databinding.FragmentHomeBinding;
import com.androidapp.myquizapp.presenter.AppPresenter;
import com.androidapp.myquizapp.presenter.AppPresenterImpl;
import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView quizAppTextView;
    private Button startButton;
    private AppPresenter appPresenter;
    private FragmentHomeBinding binding;


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // init
        appPresenter = new AppPresenterImpl();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.inflate(getContext(), R.layout.fragment_home, binding.getRoot());
        // find view
        quizAppTextView = binding.tvQuizapp;
        startButton = binding.btStart;

        // set listener on start button
        startButton.setOnClickListener(this);

        binding.getRoot().setBackgroundColor(getResources().getColor(R.color.custom_blue));
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
