package edu.vassar.cmpu203.team2a.view.advisorView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.team2a.databinding.FragmentAdvisorMenuBinding;


public class AdvisorMenuFrag extends Fragment implements IAdvisorMenufrag {


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

        this.binding.addAdviseeButton4.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingAddAdvisee();
                }
        );
        this.binding.deleteAdviseeButton2.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingDeleteAdvisee();
                }
        );
    }


}