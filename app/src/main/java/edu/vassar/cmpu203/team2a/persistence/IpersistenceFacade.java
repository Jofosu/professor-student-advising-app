package edu.vassar.cmpu203.team2a.persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Major;

public interface IpersistenceFacade {
    void saveAdvisee(Advisee advisee);
    void savePool(Major major);

    interface DataListener<T>{
    void onDataRecieved(@NonNull T data);
    void onNoDataFound();
    }

    void retrieveAdvisor(@NonNull DataListener<Advisor> listener);

}
