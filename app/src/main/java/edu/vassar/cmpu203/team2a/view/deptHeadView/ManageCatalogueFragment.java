package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Set;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentManageCatalogueMenuBinding;
import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;

public class ManageCatalogueFragment extends Fragment implements IManageCatalogueMenu {
    private ControllerActivity activity;
    FragmentManageCatalogueMenuBinding binding;
    IManageCatalogueMenu.Listener listener;

    public ManageCatalogueFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.binding = FragmentManageCatalogueMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        activity = (ControllerActivity) getActivity();
        updateMenuDisplay(activity.getCourseCatalogue());

        this.binding.addCourse.setOnClickListener((clickedView) -> {
            listener.onAddCourse();
        });

        this.binding.removeCourse.setOnClickListener((clickedView) -> {
                     listener.onRemoveCourse();
                }
        );


    }

    public void updateMenuDisplay(CourseCatalogue courseCatalogue) {
        Set<String> courses = courseCatalogue.returnCourseList();
        for (String course : courses) {
            this.binding.listofCourses.append("\n" +course);


        }


    }
}
