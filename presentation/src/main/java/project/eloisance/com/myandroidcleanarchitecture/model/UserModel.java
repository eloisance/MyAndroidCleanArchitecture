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

  public int getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
