package edu.vassar.cmpu203.team2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import edu.vassar.cmpu203.team2a.view.IAddDeptCourseView;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.view.IMainView;

public class MainActivity extends AppCompatActivity implements IAddDeptCourseView.Listener {
    private Course course;
    private IMainView mainView;
    private CourseCatalogue courseCatalogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAddedCourse(String id, String time, IAddDeptCourseView AddDeptCourseView) {
        Log.d("AdvisingApp", "controller is handling adding a course");

        this.courseCatalogue.addCourse(id, time);
        AddDeptCourseView.updateDisplay(this.course);
    }

    @Override
    public void onCourseDone() {

    }
}