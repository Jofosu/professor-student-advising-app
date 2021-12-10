package edu.vassar.cmpu203.team2a.view.deptHeadView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IManagePoolsFragment {
    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);
    interface Listener{
        void onRemovePoolCourse();
        void onAddPoolCourse();

        void onViewPoolCourses(String idString);
    }
}
