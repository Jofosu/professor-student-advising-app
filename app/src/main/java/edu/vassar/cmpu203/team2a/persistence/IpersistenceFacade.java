package edu.vassar.cmpu203.team2a.persistence;

import androidx.annotation.NonNull;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;

public interface IpersistenceFacade {
    void saveAdvisee(Advisee advisee);

    interface DataListener<T>{
    void onDataRecieved(@NonNull T data);
    void onNoDataFound();
    }

    void retrieveAdvisor(@NonNull DataListener<Advisor> listener);

}
