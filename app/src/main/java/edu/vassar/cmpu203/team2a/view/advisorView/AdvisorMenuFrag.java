package edu.vassar.cmpu203.team2a.view.advisorView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Set;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentAdvisorMenuBinding;
import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;


public class AdvisorMenuFrag extends Fragment implements IAdvisorMenufrag {

    private ControllerActivity activity;
    FragmentAdvisorMenuBinding binding;
    IAdvisorMenufrag.Listener listener;



    public AdvisorMenuFrag(Listener listener) {this.listener= listener;}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentAdvisorMenuBinding.inflate(inflater);

        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        activity = (ControllerActivity)getActivity();


        updateMenuDisplay(activity.getAdvisor());

        this.binding.addAdviseeButton4.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingAddAdvisee();
                }
        );
        this.binding.deleteAdviseeButton2.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingDeleteAdvisee();
                }
        );

    }



    public void updateMenuDisplay(Advisor advisor) {
        if(advisor.returnAdviseeList().size() >=0) {
            String advisees = advisor.adviseeNames();
            this.binding.adviseesLabel.setText(advisees);
        }
    }
}