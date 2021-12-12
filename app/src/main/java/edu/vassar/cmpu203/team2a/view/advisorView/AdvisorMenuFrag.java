package edu.vassar.cmpu203.team2a.view.advisorView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentAdvisorMenuBinding;


public class AdvisorMenuFrag extends Fragment implements IAdvisorMenuView {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ControllerActivity activity;
    FragmentAdvisorMenuBinding binding;
    IAdvisorMenuView.Listener listener;


    public AdvisorMenuFrag(Listener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentAdvisorMenuBinding.inflate(inflater);

        return this.binding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        updateMenuDisplay();


        this.binding.addAdviseeButton4.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingAddAdvisee();
                }
        );
        this.binding.deleteAdviseeButton2.setOnClickListener((clickedView) -> {
                    this.listener.onSelectingDeleteAdvisee();
                }
        );


    }


    /**
     * Keep track of the advisees and advisor has and adds the advisee list to the recycle class view
     */
    @Override
    public void updateMenuDisplay() {

    }
    }

