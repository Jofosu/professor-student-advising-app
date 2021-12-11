package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;
import java.util.regex.Pattern;

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
                Boolean accept = true;
                Pattern coursePrefixOrder = Pattern.compile("^[a-zA-Z]{4}+[0-9]{3}+$");
                Pattern courseTimeOrder = Pattern.compile("^[0-9]+[:]+[0-9]+$");

                Editable courseIDEditable = binding.editCourseID.getText();
                String courseID = courseIDEditable.toString().toUpperCase(Locale.ROOT);
                if(!coursePrefixOrder.matcher(courseID).find()){
                    Snackbar.make(view, "Please use a proper course ID",Snackbar.LENGTH_LONG).show();
                    accept= false;
                }


                Boolean thursday = binding.thursday.isChecked();
                Boolean friday = binding.friday.isChecked();

                String time = "";
                if (thursday)
                    time += "F";
                if (friday)
                    time += "S";
                if(time.equals("")){
                    accept = false;
                    Snackbar.make(view, "Please select semester",Snackbar.LENGTH_LONG).show();
                }
                if(accept)
                    this.listener.onAddedCourse(courseID, time);

            });
    }

}

