package edu.vassar.cmpu203.team2a.view.deptHeadView;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Set;

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentPoolOptionsBinding;
import edu.vassar.cmpu203.team2a.model.Major;

public class PoolOptionsFragment extends Fragment implements IPoolOptionsView {
    private ControllerActivity activity;
    private FragmentPoolOptionsBinding binding;
    private final IPoolOptionsView.Listener listener;


    public PoolOptionsFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = FragmentPoolOptionsBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        activity = (ControllerActivity) getActivity();
        updatePoolDisplay(activity.getMajor());

        this.binding.CreatePool.setOnClickListener((clickedView) -> {
            listener.onCreatePoolButton();
        });

        this.binding.RemovePool.setOnClickListener((clickedView) -> {
            listener.onRemovePoolButton();
        });
    }

    public void updatePoolDisplay(Major major) {
        Set<String> poollist = major.getPools();
        for (String pool : poollist) {
            this.binding.listofPools.append("\n" + pool);
        }


    }
}