package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.team2a.databinding.FragmentDeptHeadMenuBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentPoolMenuBinding;


public class DeptHeadMenuFragment extends Fragment implements IDeptHeadMenu {

    FragmentDeptHeadMenuBinding binding;
    Listener listener;

    public DeptHeadMenuFragment(Listener listener){this.listener = listener;}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       this.binding = FragmentDeptHeadMenuBinding.inflate(inflater);
       return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.manageCatalogueButton.setOnClickListener((clickedView) -> {
            listener.onManageCatalogue();
        });

        this.binding.manageMajorButton.setOnClickListener((clickedView) -> {
            listener.onManageMajor();
        });
    }
}