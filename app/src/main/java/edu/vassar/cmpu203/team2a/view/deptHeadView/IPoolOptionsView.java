package edu.vassar.cmpu203.team2a.view.deptHeadView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;

public interface IPoolOptionsView {
    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);

    interface Listener{

        void onCreatePoolButton();

        void onRemovePoolButton();
    }
    void updatePoolDisplay(Major major);

}
