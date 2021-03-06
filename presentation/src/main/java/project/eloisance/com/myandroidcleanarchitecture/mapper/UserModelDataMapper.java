package project.eloisance.com.myandroidcleanarchitecture.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import project.eloisance.com.domain.User;
import project.eloisance.com.myandroidcleanarchitecture.internal.di.PerActivity;
import project.eloisance.com.myandroidcleanarchitecture.model.UserModel;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {}

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link UserModel}.
     */
    public UserModel transform(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        final UserModel userModel = new UserModel(user.getUserId());
        userModel.setName(user.getName());
        userModel.setEmail(user.getEmail());

        return userModel;
    }

    /**
     * Transform a Collection of {@link User} into a Collection of {@link UserModel}.
     *
     * @param usersCollection Objects to be transformed.
     * @return List of {@link UserModel}.
     */
    public Collection<UserModel> transform(Collection<User> usersCollection) {
        Collection<UserModel> userModelsCollection;

        if (usersCollection != null && !usersCollection.isEmpty()) {
            userModelsCollection = new ArrayList<>();
            for (User user : usersCollection) {
                userModelsCollection.add(transform(user));
            }
        } else {
            userModelsCollection = Collections.emptyList();
        }

        return userModelsCollection;
    }
}