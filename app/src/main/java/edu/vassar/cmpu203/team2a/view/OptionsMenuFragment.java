package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.team2a.R;
import edu.vassar.cmpu203.team2a.databinding.FragmentOptionsMenuBinding;


public class OptionsMenuFragment extends Fragment implements IOptionsMenu {

    FragmentOptionsMenuBinding binding;
    Listener listener;

    public OptionsMenuFragment(Listener listener){this.listener = listener;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       this.binding = FragmentOptionsMenuBinding.inflate(inflater);
       return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.manageCoursesButton.setOnClickListener((clickedView) -> {
            listener.onManageCourses();
        });

    }
}