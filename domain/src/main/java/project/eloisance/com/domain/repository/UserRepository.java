package project.eloisance.com.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import project.eloisance.com.domain.User;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface UserRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link User}.
   */
  Observable<List<User>> users();

  /**
   * Get an {@link Observable} which will emit a {@link User}.
   *
   * @param userId The user id used to retrieve user data.
   */
  Observable<User> user(final int userId);
}
