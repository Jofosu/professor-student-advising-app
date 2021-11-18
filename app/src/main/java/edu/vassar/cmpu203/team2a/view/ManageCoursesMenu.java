package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.vassar.cmpu203.team2a.databinding.FragmentManageCoursesMenuBinding;

public class ManageCoursesMenu extends Fragment implements IManageCoursesMenu {
    FragmentManageCoursesMenuBinding binding;
    IManageCoursesMenu.Listener listener;

    public ManageCoursesMenu(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentManageCoursesMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.createPoolButton.setOnClickListener((clickedView) -> {
            listener.onCreatePool();
        });

        this.binding.editPool.setOnClickListener((clickedView) -> {
            listener.onEditPool();
        });

    }
}