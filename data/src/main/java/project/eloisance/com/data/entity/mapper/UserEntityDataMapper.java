package project.eloisance.com.data.entity.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.domain.User;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
public class UserEntityDataMapper {

  @Inject
  UserEntityDataMapper() {}

  /**
   * Transform a {@link UserEntity} into an {@link User}.
   *
   * @param userEntity Object to be transformed.
   * @return {@link User} if valid {@link UserEntity} otherwise null.
   */
  public User transform(UserEntity userEntity) {
    User user = null;
    if (userEntity != null) {
      user = new User(userEntity.getUserId());
      user.setName(userEntity.getName());
      user.setEmail(userEntity.getEmail());
    }
    return user;
  }

  /**
   * Transform a List of {@link UserEntity} into a Collection of {@link User}.
   *
   * @param userEntityCollection Object Collection to be transformed.
   * @return {@link User} if valid {@link UserEntity} otherwise null.
   */
  public List<User> transform(Collection<UserEntity> userEntityCollection) {
    final List<User> userList = new ArrayList<>(20);
    for (UserEntity userEntity : userEntityCollection) {
      final User user = transform(userEntity);
      if (user != null) {
        userList.add(user);
      }
    }
    return userList;
  }
}
