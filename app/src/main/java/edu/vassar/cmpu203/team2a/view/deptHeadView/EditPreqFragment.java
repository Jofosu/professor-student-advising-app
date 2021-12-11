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

import java.util.Locale;
import java.util.regex.Pattern;

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
            boolean accept = true;
            Pattern coursePrefixOrder = Pattern.compile("^[a-zA-Z]{4}+[0-9]{3}+$");
            Editable preq = binding.enterPreq.getText();
            String preqTargetString = preq.toString().toUpperCase(Locale.ROOT);

            if(!coursePrefixOrder.matcher(preq).find()){
                Snackbar.make(view, "Please use a proper course ID",Snackbar.LENGTH_LONG).show();
                accept= false;
            }

            Editable preqTarget = binding.enterPreqTarget.getText();
            String preqString = preqTarget.toString().toUpperCase(Locale.ROOT);

            if(!coursePrefixOrder.matcher(preqString).find()){
                Snackbar.make(view, "Please use a proper course ID",Snackbar.LENGTH_LONG).show();
                accept= false;
            }
            if(accept)
                this.listener.editPreq(preqTargetString, preqString);

        });
    }
}
