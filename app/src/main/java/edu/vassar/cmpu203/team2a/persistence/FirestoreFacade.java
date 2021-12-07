package edu.vassar.cmpu203.team2a.persistence;

import android.util.Log;

import androidx.annotation.NonNull;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;

public class FirestoreFacade implements IpersistenceFacade{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String ADVISEE = "Advisee";

    @Override
    public void saveAdvisee(@NonNull Advisee advisee) {
    db.collection(ADVISEE).add(advisee);
    }

    @Override
    public void retrieveAdvisor(@NonNull DataListener<Advisor> listener) {
        this.db.collection(ADVISEE).get()
                .addOnSuccessListener(qsnap->{
                    Advisor advisor = new Advisor();
                    for(DocumentSnapshot dsnap: qsnap){
                    Advisee advisee = dsnap.toObject(Advisee.class);
                    advisor.addAdvisee(advisee.getName(),advisee.getId(),advisee.getClassYear(),advisee.getClassesTaken());
                    }
                    listener.onDataRecieved(advisor);
                }).addOnFailureListener(e-> Log.w("AdvissingApp","Error retrieving Advisor from database",e));
    }
}
