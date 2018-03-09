package project.eloisance.com.data.repository.datasource;

import java.util.List;

import io.reactivex.Observable;
import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.data.net.RestApi;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore implements UserDataStore {

  private final RestApi restApi;

  /**
   * Construct a {@link UserDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link RestApi} implementation to use.
   */
  CloudUserDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override
  public Observable<List<UserEntity>> userEntityList() {
    return this.restApi.userEntityList();
  }

  @Override
  public Observable<UserEntity> userEntityDetails(final int userId) {
    return this.restApi.userEntityById(userId);
  }
}
