package edu.vassar.cmpu203.team2a.view.authorizeView;

public interface IAuthView {
    interface Listener{
        void onRegister(String username, String password, IAuthView authView);
        void onSignInAttempt(String username, String password, IAuthView authView);
    }

    void onRegisterSuccess();
    void onInvalidCredentials();
    void onUserAlreadyExists();
}
