package project.eloisance.com.data.repository.datasource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.robolectric.RuntimeEnvironment;

import project.eloisance.com.data.ApplicationTestCase;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserDataStoreFactoryTest extends ApplicationTestCase {

    private static final int FAKE_USER_ID = 11;

    private UserDataStoreFactory userDataStoreFactory;

    @Before
    public void setUp() {
        userDataStoreFactory = new UserDataStoreFactory(RuntimeEnvironment.application);
    }

    @Test
    public void testCreateCloudDataStore() {
        UserDataStore userDataStore = userDataStoreFactory.create(FAKE_USER_ID);
        assertThat(userDataStore, is(notNullValue()));
        assertThat(userDataStore, is(instanceOf(CloudUserDataStore.class)));
    }
}