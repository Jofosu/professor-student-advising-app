package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteAdviseeBinding;



public class DeleteAdviseeViewFragment extends Fragment implements IManageAdviseeView {

    FragmentDeleteAdviseeBinding binding;
    IManageAdviseeView.Listener listener;

    public DeleteAdviseeViewFragment(IManageAdviseeView.Listener listener){
        this.listener = listener;
    }

    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentDeleteAdviseeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    //implemented from IManageAdvisee
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.doneButton.setOnClickListener((clickedView) -> {
            Editable nameEditable = binding.nameEditText.getText();
            String name = nameEditable.toString();

            Editable classYearEditable = binding.classYearEditText.getText();
            String classYearString = classYearEditable.toString();
            int classYear = Integer.parseInt(classYearString);

            Editable idEditable = binding.idEditText.getText();
            String idString = idEditable.toString();
            int id = Integer.parseInt(idString);

            this.listener.deleteAdvisee(name, id, classYear);
        });


    }}
