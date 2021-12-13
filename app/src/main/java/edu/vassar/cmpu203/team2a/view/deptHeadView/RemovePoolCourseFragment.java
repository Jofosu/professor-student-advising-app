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

import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentDeleteCatalogueBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentEditPoolCourseBinding;
import edu.vassar.cmpu203.team2a.databinding.FragmentEnterPoolNameBinding;

/**
 * This class mainly serves to get the string from the user and tell the listener to add the course
 * into the pool. I ended up checking the string in the controlleractivity
 */
public class RemovePoolCourseFragment extends Fragment implements IEditPoolCourse {

    private FragmentEditPoolCourseBinding binding;
    private final IEditPoolCourse.Listener listener;

    public RemovePoolCourseFragment(Listener listener){
        this.listener = listener;
    }


    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        this.binding = FragmentEditPoolCourseBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        this.binding.button3.setOnClickListener((clickedView) -> {

            Editable idEditable = binding.idEntry.getEditableText();
            String idString = idEditable.toString();

            Editable idEditable2 = binding.poolEntry.getEditableText();
            String poolName = idEditable2.toString();

            this.listener.removePoolCourseController(idString, poolName);
        });

    }}
