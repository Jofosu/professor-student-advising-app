package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentAddCatalogueBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentAdvisorMenuBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentManageCatalogueMenuBinding;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;

public class AddDepartmentCourseFragment extends Fragment implements IAddDeptCourseView {
    private FragmentAddCatalogueBinding binding;
    private Listener listener;


    public AddDepartmentCourseFragment(Listener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentAddCatalogueBinding.inflate(inflater);
        return this.binding.getRoot();


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.binding.doneButton3.setOnClickListener((clickedView) -> {

            Editable courseIDEditable = binding.editCourseID.getText();
            String courseID = courseIDEditable.toString();

            Editable courseStartTime = binding.editStartTIme.getText();
            String startTime = courseStartTime.toString();

            Editable courseEndTime = binding.editEndTIme.getText();
            String endTime = courseEndTime.toString();

            Boolean monday = binding.monday.isChecked();
            Boolean tuesday = binding.tuesday.isChecked();
            Boolean wednesday = binding.wednesday.isChecked();
            Boolean thursday = binding.thursday.isChecked();
            Boolean friday = binding.friday.isChecked();

            String time = "";
            if (monday)
                time += "M";
            if (tuesday)
                time += "T";
            if (wednesday)
                time += "W";
            if (thursday)
                time += "R";
            if (friday)
                time += "F";

            time += startTime + "-" + endTime;

            this.listener.onAddedCourse(courseID, time);

        });

        }

}

