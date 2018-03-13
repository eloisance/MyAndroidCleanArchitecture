package project.eloisance.com.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import project.eloisance.com.data.entity.mapper.UserEntityJsonMapper;
import project.eloisance.com.data.net.RestApi;
import project.eloisance.com.data.net.RestApiImpl;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

    private final Context context;

    @Inject
    UserDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        return createCloudDataStore();
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createCloudDataStore() {
        final UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
        final RestApi restApi = new RestApiImpl(this.context, userEntityJsonMapper);

        return new CloudUserDataStore(restApi);
    }
}