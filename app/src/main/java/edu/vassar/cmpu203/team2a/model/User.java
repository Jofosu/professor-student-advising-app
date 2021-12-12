package edu.vassar.cmpu203.team2a.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.GenericTypeIndicator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class User implements Serializable {
    private String username;
    private AuthKey authKey;

    public User() {}

    public User(String username, String password){

        this.username = username;
        this.authKey = new AuthKey(password);
    }

    public String getUsername(){ return this.username; }
    public AuthKey getAuthKey(){ return this.authKey; }

    public boolean validatePassword(String password){
        return this.authKey.validatePassword(password);
    }

    @Override
    @NonNull
    public String toString(){
        return String.format("User %s, authKey: %s", this.username, this.authKey.toString());
    }
}
