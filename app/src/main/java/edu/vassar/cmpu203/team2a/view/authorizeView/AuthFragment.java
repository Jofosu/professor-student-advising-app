package edu.vassar.cmpu203.team2a.view.authorizeView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.getBoolean(IS_REGISTERED))
            activateRegisteredConfig();

        this.binding.registerButton.setOnClickListener((clickedView) -> {
            String username = this.binding.editTextUsername.getText().toString();
            String password = this.binding.editTextPassword.getText().toString();
            AuthFragment.this.listener.onRegister(
                    username, password, AuthFragment.this);
        });

        this.binding.signInButton.setOnClickListener((clickedView) -> {
            String username = this.binding.editTextUsername.getText().toString();
            String password = this.binding.editTextPassword.getText().toString();
            AuthFragment.this.listener.onSignInAttempt(
                    username, password, AuthFragment.this);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding= FragmentAuthBinding.inflate(inflater);
                return this.binding.getRoot();
    }

    private void activateRegisteredConfig(){
        this.isRegistered = true;
        this.binding.registerButton.setEnabled(false);
    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void onInvalidCredentials() {

    }

    @Override
    public void onUserAlreadyExists() {

    }
}