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
import edu.vassar.cmpu203.team2a.databinding.FragmentAddAdviseeBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteAdviseeBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentEnterPoolName2Binding;
import edu.vassar.cmpu203.team2a.view.advisorView.IManageAdviseeView;

public class EnterPoolNameFragment extends Fragment implements IEnterPoolName {

    private FragmentEnterPoolName2Binding binding;
    private final IEnterPoolName.Listener listener;

    public EnterPoolNameFragment(Listener listener){
        this.listener = listener;
    }


    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentEnterPoolName2Binding.inflate(inflater);
        return this.binding.getRoot();
    }

    //implemented from IManageAdvisee
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.button2.setOnClickListener((clickedView) -> {

            Editable idEditable = binding.poolEntry.getEditableText();
            String idString = idEditable.toString();
            int id = Integer.parseInt(idString);

            this.listener.removePool(idString);
        });


    }}

