package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import edu.vassar.cmpu203.team2a.databinding.FragmentAddCatalogueBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteCatalogueBinding;

public class RemoveDepartmentCourseFragment extends Fragment implements IRemoveDeptCourseView {
    private FragmentDeleteCatalogueBinding binding;
    private Listener listener;

    public RemoveDepartmentCourseFragment(Listener listener) {
        this.listener = listener;
    }
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentDeleteCatalogueBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.removeCourseButton.setOnClickListener((clickedView)->{
            Editable courseIDEditable = binding.enterRemoveID.getText();
            String courseID = courseIDEditable.toString();
            this.listener.onRemovedCourse(courseID);
        });

    }
}
