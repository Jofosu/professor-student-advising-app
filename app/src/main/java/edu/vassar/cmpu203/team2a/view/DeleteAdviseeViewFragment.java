package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteAdviseeBinding;



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
            int id = Integer.parseInt(idString);

            this.listener.deleteAdvisee(id);
        });


    }}
