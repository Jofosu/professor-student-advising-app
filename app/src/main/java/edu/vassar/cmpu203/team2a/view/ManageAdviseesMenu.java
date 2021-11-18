package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.team2a.databinding.FragmentManageAdviseesMenuBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentOptionsMenuBinding;


public class ManageAdviseesMenu extends Fragment implements IManageAdviseesMenu {

    FragmentManageAdviseesMenuBinding binding;
    Listener listener;

    public ManageAdviseesMenu(Listener listener){this.listener = listener;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentManageAdviseesMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.addAdviseeButton.setOnClickListener((clickedView) -> {
            listener.onAddAdvisee();
        });

        this.binding.deleteAdviseeButton.setOnClickListener((clickedView) ->{
            listener.onDeleteAdvisee();
        });

       /** this.binding.editAdviseeButton.setOnClickListener((clickedView) -> {
            listener.onEditAdvisee();
        });
        back end side of this does not yet exist
        */
    }



}