package eu.gillissen.topicus.model.form;

/**
 * Data object to map the result of a user registration to.
 */
public class UserRegistration {
    private String username;
    private String password;
    private String passwordCheck;

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}
