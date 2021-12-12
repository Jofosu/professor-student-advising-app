package edu.vassar.cmpu203.team2a.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.GenericTypeIndicator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class User implements Serializable {
    private String username;
    private AuthKey authKey;

    /**
     * Empty User Constructor
     */
    public User() {
    }

    /**
     * User Constructor
     *
     * @param username :username
     * @param password :password
     */
    public User(String username, String password) {

        this.username = username;
        this.authKey = new AuthKey(password);
    }

    /**
     * Getter for username field
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Getter for AuthKey field
     *
     * @return authorization key
     */
    public AuthKey getAuthKey() {
        return this.authKey;
    }

    /**
     * Checks if password entered matches with the User
     *
     * @param password
     * @return true if given password matches with the User
     */
    public boolean validatePassword(String password) {
        return this.authKey.validatePassword(password);
    }

    @Override
    @NonNull
    /**
     * toString for User, returns a string of the format User xx, authKey: xx
     */
    public String toString() {
        return String.format("User %s, authKey: %s", this.username, this.authKey.toString());
    }
}
