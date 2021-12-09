package edu.vassar.cmpu203.team2a.persistence;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;

public interface IpersistenceFacade {
    void saveAdvisee(Advisee advisee);
    void saveMajor(Major major);
    void saveCatalogue(Course course);

    interface DataListener<T>{
    void onDataRecieved(@NonNull T data);
    void onNoDataFound();
    }

    void retrieveAdvisor(@NonNull DataListener<Advisor> listener);
    void retrieveMajor(@NonNull DataListener<Major> listener);
    void retrieveCatalogue(@NonNull DataListener <CourseCatalogue> listener);

}
