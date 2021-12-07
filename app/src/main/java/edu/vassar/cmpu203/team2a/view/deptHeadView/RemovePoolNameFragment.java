package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentEnterPoolNameBinding;


public class RemovePoolNameFragment extends Fragment implements IEnterPoolName {

    private FragmentEnterPoolNameBinding binding;
    private final IEnterPoolName.Listener listener;

    public RemovePoolNameFragment(Listener listener){
        this.listener = listener;
    }


    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentEnterPoolNameBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.button2.setOnClickListener((clickedView) -> {

            Editable idEditable = binding.poolEntry.getEditableText();
            String idString = idEditable.toString();

            this.listener.removePool(idString);
        });


    }}

