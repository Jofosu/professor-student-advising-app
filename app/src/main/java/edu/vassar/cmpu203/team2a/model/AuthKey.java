package edu.vassar.cmpu203.team2a.model;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class AuthKey implements Serializable {

    private String salt;
    private String key;

    /**
     * Empty AuthKey Constructor
     */
    public AuthKey(){ }

    /**
     * AuthKey Constructor, calls another constructor after generating salt necessary for
     * saving the password
     * @param password
     */
    public AuthKey(String password){
        this(generateSalt(), password);
    }

    /**
     * AuthKey Constructor that creates the final product with salt and key
     * @param salt :salt
     * @param password : password
     */
    private AuthKey(String salt, String password){
        this.salt = salt;
        this.key = generateKey(salt, password);
    }

    /**
     * Getter for salt
     * @return String salt
     */
    public String getSalt() {
        return this.salt;
    }

    /**
     * Getter for key
     * @return String key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Creates a new AuthKey from given password then checks to see if that new key
     * matches the object's key (this.key)
     * @param password : password
     * @return true if the given password matches the one saved
     */
    public boolean validatePassword(String password){
        AuthKey okey = new AuthKey(this.salt, password);
        return this.key.equals(okey.key);
    }

    /**
     * toString method for authKey that returns its fields salt and key
     * @return a String in the format salt: xx, key: xx
     */
    @Override
    @NonNull
    public String toString() {
        return String.format("salt: %s, key: %s", this.salt, this.key);
    }

    private static final int SALT_LEN = 20;
    private static final int KEY_LEN = 40;
    private static final int NITERS = 64000;

    /**
     * Randomly generates salt for a password
     * @return a random String
     */
    @NonNull
    private static String generateSalt() {
        byte[] salt = new byte[SALT_LEN];
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            Log.e("AdvisingApp", "Error generating authentication salt", e);
        }
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Generates the unique key for the given password and salt
     * @param salt
     * @param password
     * @return a string
     */
    private static String generateKey(String salt, String password) {
        String hashStr = null;
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] saltBytes = Base64.getDecoder().decode(salt);
            char[] chars = password.toCharArray();
            PBEKeySpec spec = new PBEKeySpec(chars, saltBytes, NITERS, KEY_LEN * Byte.SIZE);

            byte[] hashBytes = skf.generateSecret(spec).getEncoded();
            hashStr = Base64.getEncoder().encodeToString(hashBytes);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("AdvisingApp", "Error generating authentication key", e);
        }
        return hashStr;
    }


}