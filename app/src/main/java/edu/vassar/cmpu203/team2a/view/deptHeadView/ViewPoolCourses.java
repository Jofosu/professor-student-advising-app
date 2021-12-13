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

import java.util.List;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentEnterPoolNameBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentListPoolCoursesBinding;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Pool;


public class ViewPoolCourses extends Fragment implements IEnterPoolName {
    private ControllerActivity activity;
    private FragmentListPoolCoursesBinding binding;
    private final IEnterPoolName.Listener listener;
    String poolName;

    public ViewPoolCourses(Listener listener, String poolName) {
        this.listener = listener;
        this.poolName = poolName;
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentListPoolCoursesBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        activity = (ControllerActivity) getActivity();
        updatePoolCoursesDisplayed(activity.getMajor());

        this.binding.button5.setOnClickListener((clickedView) -> {
            this.listener.onBackToManagePools();
        });
    }

    private void updatePoolCoursesDisplayed(Major major) {
        List<Course> poollist = major.getAPool(poolName).getpoolList();
        for (Course course : poollist) {
            this.binding.listOfPoolCourses.append("\n" + course);
        }
    }


}
