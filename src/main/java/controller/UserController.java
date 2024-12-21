package controller;

import entity.User;
import service.UserService;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ViewScoped
public class UserController implements Serializable {

    private UserService userService = new UserService();

    private String username;
    private String email;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String register() {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.register(user);
        return "login.xhtml?faces-redirect=true";
    }

    public String login() {
        boolean authenticated = userService.authenticate(username, password);
        if (authenticated) {
            return "quiz.xhtml?faces-redirect=true";
        } else {
            return "login.xhtml?error=true";
        }
    }
}
