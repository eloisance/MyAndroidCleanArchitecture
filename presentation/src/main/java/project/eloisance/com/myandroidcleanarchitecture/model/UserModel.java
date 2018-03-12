package project.eloisance.com.myandroidcleanarchitecture.model;

/**
 * Class that represents a user in the presentation layer.
 */
public class UserModel {

    private final int userId;

    public UserModel(int userId) {
        this.userId = userId;
    }

    private String name;

    private String email;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}