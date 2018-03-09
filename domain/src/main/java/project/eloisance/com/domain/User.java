package project.eloisance.com.domain;

/**
 * Class that represents a User in the domain layer.
 */
public class User {

  private final int userId;

  public User(int userId) {
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
