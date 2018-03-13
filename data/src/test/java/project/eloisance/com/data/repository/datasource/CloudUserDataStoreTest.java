package project.eloisance.com.data.repository.datasource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;
import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.data.net.RestApi;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CloudUserDataStoreTest {

    private static final int FAKE_USER_ID = 765;

    private CloudUserDataStore cloudUserDataStore;

    @Mock private RestApi mockRestApi;

    @Before
    public void setUp() {
        cloudUserDataStore = new CloudUserDataStore(mockRestApi);
    }

    @Test
    public void testGetUserEntityListFromApi() {
        cloudUserDataStore.userEntityList();
        verify(mockRestApi).userEntityList();
    }

    @Test
    public void testGetUserEntityDetailsFromApi() {
        UserEntity fakeUserEntity = new UserEntity();
        Observable<UserEntity> fakeObservable = Observable.just(fakeUserEntity);
        given(mockRestApi.userEntityById(FAKE_USER_ID)).willReturn(fakeObservable);
        cloudUserDataStore.userEntityDetails(FAKE_USER_ID);
        verify(mockRestApi).userEntityById(FAKE_USER_ID);
    }
}