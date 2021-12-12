package edu.vassar.cmpu203.team2a.view.advisorView;

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
import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteAdviseeBinding;
import edu.vassar.cmpu203.team2a.model.UserInputValidator;


public class DeleteAdviseeViewFragment extends Fragment implements IManageAdviseeView {

   private FragmentDeleteAdviseeBinding binding;
   private final IManageAdviseeView.Listener listener;

    public DeleteAdviseeViewFragment(Listener listener){
        this.listener = listener;
    }

    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentDeleteAdviseeBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    //implemented from IManageAdvisee
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.button.setOnClickListener((clickedView) -> {

            Editable idEditable = binding.editStudentId2.getEditableText();
            String idString = idEditable.toString();
            ControllerActivity activity = (ControllerActivity) getActivity();

            if(!UserInputValidator.isValidStudentId(idString) || activity.getAdvisor().getAdvisee(Integer.parseInt(idString)) == null) Snackbar.make(view, "Please type valid student id", Snackbar.LENGTH_LONG).show();
            else this.listener.deleteAdvisee(Integer.parseInt(idString));
        });


    }


}
