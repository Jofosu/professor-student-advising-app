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
    private final IManageAdviseeView.Listener listener;

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
            Editable firstNameEditable = binding.editFirstName.getText();
            String firstname = firstNameEditable.toString();

                Editable middleNameEditable = binding.editMiddleName.getText();
                String middleName = middleNameEditable.toString();

                Editable lastNameEditable = binding.editLastName.getText();
                String lastName = lastNameEditable.toString();

                String fullName = firstname+ " " + middleName+ " " + lastName;
            Editable classYearEditable = binding.editClassYear.getText();
            String classYearString = classYearEditable.toString();
                int classYear = -1;

                try{
                    classYear = Integer.parseInt((classYearString));

                }catch (NumberFormatException e){}

                if (classYear < 2022 || classYear> 2024) {
                    Snackbar.make(view, "Invalid class Year. Please provide a current class year in the pattern 20XX.",Snackbar.LENGTH_LONG).show();
                }

            Editable idEditable = binding.editStudentId.getText();
            String idString = idEditable.toString();
            int id = Integer.parseInt(idString);





            this.listener.addAdvisee(fullName, id, classYear);
        });


    }

}