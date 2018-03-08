package project.eloisance.com.data.net;

import java.net.MalformedURLException;
import java.util.List;

import io.reactivex.Observable;
import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.data.entity.mapper.UserEntityJsonMapper;
import project.eloisance.com.data.exception.NetworkConnectionException;

public class RestApiImpl implements RestApi {

    private final UserEntityJsonMapper userEntityJsonMapper;

    public RestApiImpl(UserEntityJsonMapper userEntityJsonMapper) {
        this.userEntityJsonMapper = userEntityJsonMapper;
    }

    /**
     *
     * @return
     * @throws MalformedURLException
     */
    private String getUserEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
    }

    /**
     *
     * @param userId
     * @return
     * @throws MalformedURLException
     */
    private String getUserDetailsFromApi(int userId) throws MalformedURLException {
        String apiUrl = API_URL_GET_USER_DETAILS + userId;
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }

    /**
     *
     * @return
     */
    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return Observable.create(emitter -> {
            try {
                String responseUserEntities = getUserEntitiesFromApi();
                if (responseUserEntities != null) {
                    emitter.onNext(userEntityJsonMapper.transformUserEntityCollection(
                            responseUserEntities));
                    emitter.onComplete();
                } else {
                    emitter.onError(new NetworkConnectionException());
                }
            } catch (Exception e) {
                emitter.onError(new NetworkConnectionException(e.getCause()));
            }
        });
    }

    /**
     *
     * @param userId The user id used to get user data.
     * @return
     */
    @Override
    public Observable<UserEntity> userEntityById(int userId) {
        return Observable.create(emitter -> {
            try {
                String responseUserDetails = getUserDetailsFromApi(userId);
                if (responseUserDetails != null) {
                    emitter.onNext(userEntityJsonMapper.transformUserEntity(responseUserDetails));
                    emitter.onComplete();
                } else {
                    emitter.onError(new NetworkConnectionException());
                }
            } catch (Exception e) {
                emitter.onError(new NetworkConnectionException(e.getCause()));
            }
        });
    }
}
