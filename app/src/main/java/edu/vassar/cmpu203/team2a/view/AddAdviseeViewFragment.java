package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.team2a.databinding.FragmentAddAdviseeBinding;


public class AddAdviseeViewFragment extends Fragment implements IManageAdviseeView {

    private FragmentAddAdviseeBinding binding;
    private IManageAdviseeView.Listener listener;

    public AddAdviseeViewFragment(Listener listener){
        this.listener = listener;
    }

    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentAddAdviseeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    //implemented from IManageAdvisee
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

            this.binding.doneButton3.setOnClickListener((clickedView) -> {
            Editable nameEditable = binding.studentName.getText();
            String name = nameEditable.toString();

            Editable classYearEditable = binding.classYear.getText();
            String classYearString = classYearEditable.toString();
                int classYear = -1;

                try{
                    classYear = Integer.parseInt((classYearString));

                }catch (NumberFormatException e){}

                if (classYear < 2022 || classYear> 2024) {
                    Snackbar.make(view, "Invalid class Year. Please provide a current class year in the pattern 20XX.",Snackbar.LENGTH_LONG).show();
                }else{
                    classYearEditable.clear();

                }

            Editable idEditable = binding.studentIdLabel.getText();
            String idString = idEditable.toString();
            int id = Integer.parseInt(idString);





            this.listener.addAdvisee(name, id, classYear);
        });


    }

}