package edu.vassar.cmpu203.team2a.view.authorizeView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.team2a.R;
import edu.vassar.cmpu203.team2a.databinding.FragmentAuthBinding;


/**
 *
 */

public class AuthFragment extends Fragment implements IAuthView{


    private static final String IS_REGISTERED = "isRegistered";
    private Listener listener;
    private FragmentAuthBinding binding;

    private boolean isRegistered = false;

    public AuthFragment(@NonNull Listener listener) {
        this.listener = listener;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.getBoolean(IS_REGISTERED))
            activateRegisteredConfig();

        this.binding.registerButton.setOnClickListener((clickedView) -> {
            String username = this.binding.editTextUsername.getText().toString();
            String password = this.binding.editTextPassword.getText().toString();

            if(!username.equals("") & !password.equals("")) {
            AuthFragment.this.listener.onRegister(
                    username, password, AuthFragment.this);
        }
        });

        this.binding.signInButton.setOnClickListener((clickedView) -> {
            String username = this.binding.editTextUsername.getText().toString();
            String password = this.binding.editTextPassword.getText().toString();

            if(!username.equals("") & !password.equals("")) {
                AuthFragment.this.listener.onSignInAttempt(
                        username, password, AuthFragment.this);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding= FragmentAuthBinding.inflate(inflater);
                return this.binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_REGISTERED, this.isRegistered);
    }

    private void activateRegisteredConfig(){
        this.isRegistered = true;
        this.binding.registerButton.setEnabled(false);
    }

    @Override
    public void onRegisterSuccess() {
        activateRegisteredConfig();
        Snackbar.make(this.binding.getRoot(),
                "Registration successful. Please sign in",
                Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onInvalidCredentials() {
        Snackbar.make(this.binding.getRoot(),
                "Sign in failed. Invalid Credentials.",
                Snackbar.LENGTH_LONG)
                .show();

    }

    @Override
    public void onUserAlreadyExists() {
        Snackbar.make(this.binding.getRoot(),
                "Registration failed. Username already exists.",
                Snackbar.LENGTH_LONG)
                .show();

    }
}