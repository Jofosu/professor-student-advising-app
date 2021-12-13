package edu.vassar.cmpu203.team2a.view.advisorView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.vassar.cmpu203.team2a.R;
import edu.vassar.cmpu203.team2a.controller.ControllerActivity;
import edu.vassar.cmpu203.team2a.databinding.FragmentAdviseeInfoBinding;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;

public class AdviseeInfoFragment extends Fragment implements IAdviseeInfoView {

    private ControllerActivity activity;
    FragmentAdviseeInfoBinding binding;
    IAdviseeInfoView.Listener listener;




    public AdviseeInfoFragment(Listener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentAdviseeInfoBinding.inflate(inflater);
                return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String advisee = "";
        if (bundle != null) {
            advisee = bundle.getString("adviseeName");
        }

        this.binding.adviseeName.setText(advisee);
        activity = (ControllerActivity) getActivity();
        Advisor advisor = activity.getAdvisor();
        int adviseeId = advisor.getAdviseeID(advisee);
        this.binding.studentId.setText("Student Id: " + adviseeId);
        int classYear = advisor.getAdvisee(adviseeId).getClassYear();
        this.binding.classYear.setText("Class Year: " + classYear);
        updateDisplay(advisee);

        List<Course> coursesNeeded = advisor.getAdvisee(adviseeId).getClassesNeeded(activity.getCourseCatalogue());


        String finalAdvisee = advisee;
        this.binding.AddCoursesTaken.setOnClickListener((clickedView) -> {
            PopupMenu popupMenu = new PopupMenu(this.activity, this.binding.AddCoursesTaken);
            int count = 1;
            for (Course course : coursesNeeded) {
                popupMenu.getMenu().add(Menu.NONE, count, count, course.getId());
                count++;
            }


            popupMenu.getMenuInflater()
                    .inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(getContext(), "You clicked : " + item.getTitle(), Toast.LENGTH_LONG).show();

                    List<Course> x = advisor.getAdvisee(adviseeId).getClassesNeeded(activity.getCourseCatalogue());
                               Course s = x.get(item.getItemId());
                               x.remove(s);
                    updateDisplay(finalAdvisee);
                    //activity.getPersistenceFacade().updateAdviseeClasses(advisor.getAdvisee(adviseeId), activity.getCourseCatalogue().get(item.toString()));
                //view.invalidate();
                    return true;
                }
            });
            popupMenu.show();

        });


    }


    @Override
    public void updateDisplay(String advisee) {


        activity = (ControllerActivity) getActivity();
        Advisor advisor = activity.getAdvisor();
        int adviseeId = advisor.getAdviseeID(advisee);
        this.binding.studentId.setText("Student Id: " + adviseeId);
        int classYear = advisor.getAdvisee(adviseeId).getClassYear();
        this.binding.classYear.setText("Class Year: " + classYear);


        List<Course> coursesNeeded = advisor.getAdvisee(adviseeId).getClassesNeeded(activity.getCourseCatalogue());


        String str = "";
        for (Course course : coursesNeeded) {
            this.binding.checkedTextView2.append("\n" + course.toString() + "\n" );


        }


    }


}
