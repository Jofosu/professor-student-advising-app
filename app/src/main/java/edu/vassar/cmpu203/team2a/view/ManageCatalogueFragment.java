package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.team2a.databinding.FragmentAddDeptCourseBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentManageCatalogueMenuBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentOptionsMenuBinding;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;

public class ManageCatalogueFragment extends Fragment implements IManageCatalogueMenu {
    FragmentOptionsMenuBinding binding;
    IManageCatalogueMenu.Listener listener;

    public ManageCatalogueFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentOptionsMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.manageCoursesButton.setOnClickListener((clickedView) -> {
            listener.onSelectAdd();
        });


    }

    @Override
    public void updateDisplay(CourseCatalogue catalogue) {

    }
}