package eu.gillissen.topicus.model.form;

/**
 * Data object to map the result of a user registration to.
 */
public class UserRegistration {
    private String name;
    private String password;
    private String passwordCheck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
