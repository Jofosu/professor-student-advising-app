package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.vassar.cmpu203.team2a.databinding.FragmentManageCatalogueMenuBinding;

public class ManageCatalogueMenu extends Fragment implements IManageCatalogueMenu {
    FragmentManageCatalogueMenuBinding binding;
    IManageCatalogueMenu.Listener listener;

    public ManageCatalogueMenu(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentManageCatalogueMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.addCourse.setOnClickListener((clickedView) -> {
            listener.onAddCourse();
        });

        this.binding.removeCourse.setOnClickListener((clickedView) -> {
            listener.onRemoveCourse();
        });

    }
}