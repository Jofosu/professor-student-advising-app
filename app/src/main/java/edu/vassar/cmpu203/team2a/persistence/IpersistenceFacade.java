package edu.vassar.cmpu203.team2a.persistence;

import androidx.annotation.NonNull;

import java.util.List;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Pool;
import edu.vassar.cmpu203.team2a.model.User;

public interface IpersistenceFacade {
    void saveAdvisee(Advisee advisee);
    void savePool(Pool pool);
    void removePool (Pool pool);
    void saveCatalogue(Course course);
    void editCatalogue(Course course);
    void deleteCatalogue(Course course);
    void editPreq(Course course);

    void removeAdvisee(Advisee advisee);

    List<String> retrieveCoursesTaken(Advisee advisee);

    void updateAdviseeClasses(Advisee advisee, Course course);

    void addPoolCourse(Course course, String poolName);




    interface DataListener<T>{
    void onDataReceived(@NonNull T data);
    void onNoDataFound();
    }

    interface BinaryResultListener {
        void onYesResult();
        void onNoResult();
    }

//authentication related
    void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener);
    void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener);

    void retrieveAdvisor(@NonNull DataListener<Advisor> listener);
    void retrieveMajor(@NonNull DataListener<Major> listener);
    void retrieveCatalogue(@NonNull DataListener <CourseCatalogue> listener);

}
