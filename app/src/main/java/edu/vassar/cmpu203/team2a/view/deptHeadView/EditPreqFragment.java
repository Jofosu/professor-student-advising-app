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
import edu.vassar.cmpu203.team2a.databinding.FragmentAddPreqBinding;
public class EditPreqFragment extends Fragment implements IEditPreq {
    private ControllerActivity activity;
    FragmentAddPreqBinding binding;
    IEditPreq.Listener listener;

    public EditPreqFragment(Listener listener) {this.listener = listener;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.binding = FragmentAddPreqBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        activity = (ControllerActivity) getActivity();

        this.binding.enterPreqButton.setOnClickListener((clickedView) ->{
            Editable preq = binding.enterPreq.getText();
            String preqTargetString = preq.toString();

            Editable preqTarget = binding.enterPreqTarget.getText();
            String preqString = preqTarget.toString();

            this.listener.editPreq(preqTargetString, preqString);

        });
    }
}
