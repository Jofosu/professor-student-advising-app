package edu.vassar.cmpu203.team2a.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.vassar.cmpu203.team2a.databinding.FragmentMainMenuBinding;


public class MainMenuFragment extends Fragment implements IMainMenuFragment{

    FragmentMainMenuBinding binding;
    IMainMenuFragment.Listener listener;

    public MainMenuFragment(Listener listener){
        this.listener = listener;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentMainMenuBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        this.binding.advisorButtton.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingAdvisor();
                }
        );
        this.binding.hodButon.setOnClickListener( (clickedView) -> {
                    this.listener.onSelectingHOD();
                }
        );

    }


    }
