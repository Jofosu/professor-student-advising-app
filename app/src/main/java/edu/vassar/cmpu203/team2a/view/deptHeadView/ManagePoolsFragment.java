package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentManagePoolsBinding;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.Pool;

public class ManagePoolsFragment extends Fragment implements IManagePoolsFragment {
    private ControllerActivity activity;
    private FragmentManagePoolsBinding binding;
    private final IManagePoolsFragment.Listener listener;

    public ManagePoolsFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentManagePoolsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        activity = (ControllerActivity) getActivity();

        this.binding.addPoolButton.setOnClickListener((clickedView) -> {
            listener.onAddPoolCourse();
        });

        this.binding.removePoolCourse.setOnClickListener((clickedView) -> {
            listener.onRemovePoolCourse();
        });

        this.binding.viewpoolcourses.setOnClickListener((clickedView) -> {
            Editable idEditable = binding.poolEntry.getEditableText();
            String idString = idEditable.toString();
            listener.onViewPoolCourses(idString);
        });
    }


}