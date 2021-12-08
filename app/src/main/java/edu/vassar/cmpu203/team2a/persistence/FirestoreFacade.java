package edu.vassar.cmpu203.team2a.persistence;

import android.util.Log;

import androidx.annotation.NonNull;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Major;

public class FirestoreFacade implements IpersistenceFacade{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String ADVISEE = "Advisees";
    private static final String MAJOR = "Major";


    @Override
    public void saveAdvisee(@NonNull Advisee advisee) {
    db.collection(ADVISEE).add(advisee);
    }

    @Override
    public void saveMajor(@NonNull Major major) {
        db.collection(MAJOR).add(major);
    }



    @Override
    public void retrieveAdvisor(@NonNull DataListener<Advisor> listener) {
        this.db.collection(ADVISEE).get()
                .addOnSuccessListener(qsnap->{
                    Advisor advisor = new Advisor();
                    for(DocumentSnapshot dsnap: qsnap){
                    Advisee advisee = dsnap.toObject(Advisee.class);
                    advisor.addAdvisee(advisee.getName(),(int)advisee.getId(),(int)advisee.getClassYear(),advisee.getClassesTaken());
                    }
                    listener.onDataRecieved(advisor);
                }).addOnFailureListener(e-> Log.w("AdvissingApp","Error retrieving Advisor from database",e));
    }

    public void retrieveMajor(@NonNull DataListener<Major> listener) {
        this.db.collection(MAJOR).get()
                .addOnSuccessListener(qsnap->{
                    Major major = new Major();
                    for(DocumentSnapshot dsnap: qsnap){
                        Major.Pool pool = dsnap.toObject(Major.Pool.class);
                        major.createPool(pool.getpoolName());
                    }
                    listener.onDataRecieved(major);
                }).addOnFailureListener(e-> Log.w("AdvissingApp","Error retrieving major from database",e));
    }
}
