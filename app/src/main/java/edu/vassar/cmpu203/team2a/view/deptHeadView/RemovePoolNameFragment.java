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

/**
 * This class mainly serves to get the string from the user and tell the listener to add the pool
 */
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

    /**
     * Reads the input and ask the controller to remove the pool from list of pools from the major
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.button2.setOnClickListener((clickedView) -> {

            Editable idEditable = binding.poolEntry.getEditableText();
            String idString = idEditable.toString();

            if (idString.matches("")) //checks for empty input to not crash the app
            {Snackbar.make(view, "Please input a pool name",Snackbar.LENGTH_LONG).show();}

            else this.listener.removePool(idString);
        });


    }}

