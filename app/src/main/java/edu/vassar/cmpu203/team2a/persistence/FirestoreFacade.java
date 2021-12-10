package edu.vassar.cmpu203.team2a.persistence;

import android.util.Log;

import androidx.annotation.NonNull;


import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.LinkedList;

import edu.vassar.cmpu203.team2a.model.Advisee;
import edu.vassar.cmpu203.team2a.model.Advisor;
import edu.vassar.cmpu203.team2a.model.Course;
import edu.vassar.cmpu203.team2a.model.CourseCatalogue;
import edu.vassar.cmpu203.team2a.model.Major;
import edu.vassar.cmpu203.team2a.model.Pool;
import edu.vassar.cmpu203.team2a.model.User;

public class FirestoreFacade implements IpersistenceFacade{
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String ADVISEE = "Advisees";
    private static final String MAJOR = "Major";
    private static final String CATALOGUE = "Catalogue";
    private static final String USERS = "users";

    @Override
    public void saveAdvisee(@NonNull Advisee advisee) {
    db.collection(ADVISEE).add(advisee);
    }

    @Override
    public void saveMajor(@NonNull Major major) {
        db.collection(MAJOR).add(major);
    }

    @Override
    public void saveCatalogue(@NonNull Course course){db.collection(CATALOGUE).document(course.getId()).set(course);}

    @Override
    public void editCatalogue(@NonNull Course course){db.collection(CATALOGUE).document(course.getId()).set(course);}

    @Override
    public void editPreq(@NonNull Course course){db.collection(CATALOGUE).document(course.getId()).set(course);}

    @Override
    public void deleteCatalogue(@NonNull Course course){db.collection(CATALOGUE).document(course.getId()).delete();}

    @Override
    public void retrieveAdvisor(@NonNull DataListener<Advisor> listener) {
        this.db.collection(ADVISEE).get()
                .addOnSuccessListener(qsnap->{
                    Advisor advisor = new Advisor();
                    for(DocumentSnapshot dsnap: qsnap){
                    Advisee advisee = dsnap.toObject(Advisee.class);
                    advisor.addAdvisee(advisee.getName(),advisee.getId(),advisee.getClassYear(),advisee.getClassesTaken());
                    }
                    listener.onDataReceived(advisor);
                }).addOnFailureListener(e -> Log.w("AdvissingApp", "Error retrieving Advisor from database", e));
    }

    @Override
    public void retrieveMajor(@NonNull DataListener<Major> listener) {
        this.db.collection(MAJOR).get()
                .addOnSuccessListener(qsnap->{
                    Major major = new Major();
                    for(DocumentSnapshot dsnap: qsnap){
                        Pool pool = dsnap.toObject(Pool.class);
                        major.createPool(pool.getpoolName());
                    }
                    listener.onDataReceived(major);
                }).addOnFailureListener(e -> Log.w("AdvisingApp", "Error retrieving major from database", e));
    }
    @Override
    public void retrieveCatalogue(@NonNull DataListener<CourseCatalogue> listener) {
        this.db.collection(CATALOGUE).get()
                .addOnSuccessListener(qsnap->{
                    CourseCatalogue courseCatalogue = new CourseCatalogue();
                    for(DocumentSnapshot dsnap: qsnap){
                        Course course = dsnap.toObject(Course.class);
                       courseCatalogue.addCourse(course.getId(), course.getTime(),course.getPrerequisites());
                    }
                    listener.onDataReceived(courseCatalogue);
                }).addOnFailureListener(e -> Log.w("AdvisingApp", "Error retrieving catalogue from database", e));
    }

    @Override
    public void createUserIfNotExists(@NonNull User user, @NonNull BinaryResultListener listener) {

        this.retrieveUser(user.getUsername(), new DataListener<User>() {
                    @Override
                    public void onDataReceived(@NonNull User user) { // there's data there, so no go
                        listener.onNoResult();
                    }

                    @Override
                    public void onNoDataFound() { // there's no data there, so we can add the user
                        FirestoreFacade.this.setUser(user, listener);
                    }
                }
        );
    }

    private void setUser(@NonNull User user, @NonNull BinaryResultListener listener) {
        this.db.collection(USERS)
                .document(user.getUsername())
                .set(user)
                .addOnSuccessListener(avoid -> listener.onYesResult())
                .addOnFailureListener(e ->
                        Log.w("AdvisingApp", "Error adding user to database", e));
    }

    @Override
    public void retrieveUser(@NonNull String username, @NonNull DataListener<User> listener) {

        this.db.collection(USERS).document(username).get()
                .addOnSuccessListener(dsnap -> {
                    if (dsnap.exists()) {
                        User user = dsnap.toObject(User.class);
                        assert (user != null);
                        listener.onDataReceived(user);
                    } else listener.onNoDataFound();
                })
                .addOnFailureListener(e ->
                        Log.w("AdvisingApp", "Error retrieving user from database", e));
    }
}
