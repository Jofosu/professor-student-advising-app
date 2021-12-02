package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import edu.vassar.cmpu203.team2a.databinding.FragmentPoolMenuBinding;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.view.deptHeadView.IManageCatalogueMenu;

public class ManageCatalogueFragment extends Fragment implements IManageCatalogueMenu {
    FragmentPoolMenuBinding binding;
    IManageCatalogueMenu.Listener listener;

    public ManageCatalogueFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentPoolMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.createPoolButton.setOnClickListener((clickedView) -> {
            listener.onSelectAdd();
        }
        );

            this.binding.createPoolButton.setOnClickListener((clickedView) -> {
            listener.onSelectCreatePool();
                    }
                    );
    }


    @Override
    public void updateDisplay(CourseCatalogue catalogue) {

    }
}