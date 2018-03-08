package project.eloisance.com.data;

import org.junit.Test;

import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.data.entity.mapper.UserEntityJsonMapper;
import project.eloisance.com.data.net.RestApi;
import project.eloisance.com.data.net.RestApiImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserEntityUnitTest {

    private static final int FAKE_USER_ID = 123;
    private static final String FAKE_NAME = "Tony Stark";

    @Test
    public void testFakeUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(FAKE_USER_ID);
        userEntity.setName(FAKE_NAME);

        assertNotNull(userEntity);
        assertEquals(userEntity.getUserId(), FAKE_USER_ID);
        assertEquals(userEntity.getName(), FAKE_NAME);
    }

    @Test
    public void testUserEntityById() {
        UserEntityJsonMapper jsonMapper = new UserEntityJsonMapper();
        RestApi restApi = new RestApiImpl(jsonMapper);

        restApi.userEntityById(1).subscribe(user -> {
            assertNotNull(user);
            assertEquals(1, user.getUserId());
            assertEquals("Leanne Graham", user.getName());
        });
    }

    @Test
    public void testUserEntityList() {
        UserEntityJsonMapper jsonMapper = new UserEntityJsonMapper();
        RestApi restApi = new RestApiImpl(jsonMapper);

        restApi.userEntityList().subscribe(users -> {
            assertEquals(10, users.size());
        });
    }
}