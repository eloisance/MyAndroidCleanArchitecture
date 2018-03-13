package project.eloisance.com.data.entity.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import project.eloisance.com.data.entity.UserEntity;
import project.eloisance.com.data.entity.mapper.UserEntityJsonMapper;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserEntityJsonMapperTest {

    private UserEntityJsonMapper userEntityJsonMapper;

    @Before
    public void setUp() {
        userEntityJsonMapper = new UserEntityJsonMapper();
    }

    @Test
    public void testTransformUserEntityHappyCase() {
        UserEntity userEntity = userEntityJsonMapper.transformUserEntity(JSON_RESPONSE_USER_DETAILS);
        assertEquals(userEntity.getUserId(), 1);
        assertEquals(userEntity.getName(), "Leanne Graham");
        assertEquals(userEntity.getEmail(), "Sincere@april.biz");
    }

    @Test
    public void testTransformUserEntityCollectionHappyCase() {
        Collection<UserEntity> userEntityCollection = userEntityJsonMapper.transformUserEntityCollection(JSON_RESPONSE_USER_COLLECTION);
        assertEquals(((UserEntity) userEntityCollection.toArray()[0]).getUserId(), 5);
        assertEquals(((UserEntity) userEntityCollection.toArray()[1]).getUserId(), 6);
        assertEquals(((UserEntity) userEntityCollection.toArray()[0]).getEmail(), "Lucio_Hettinger@annie.ca");
        assertEquals(userEntityCollection.size(), 2);
    }

    private static final String JSON_RESPONSE_USER_DETAILS = "{\n"+
            "    \"id\": 1,\n"+
            "    \"name\": \"Leanne Graham\",\n"+
            "    \"username\": \"Bret\",\n"+
            "    \"email\": \"Sincere@april.biz\",\n"+
            "    \"address\": {\n"+
            "      \"street\": \"Kulas Light\",\n"+
            "      \"suite\": \"Apt. 556\",\n"+
            "      \"city\": \"Gwenborough\",\n"+
            "      \"zipcode\": \"92998-3874\",\n"+
            "      \"geo\": {\n"+
            "        \"lat\": \"-37.3159\",\n"+
            "        \"lng\": \"81.1496\"\n"+
            "      }\n"+
            "    },\n"+
            "    \"phone\": \"1-770-736-8031 x56442\",\n"+
            "    \"website\": \"hildegard.org\",\n"+
            "    \"company\": {\n"+
            "      \"name\": \"Romaguera-Crona\",\n"+
            "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n"+
            "      \"bs\": \"harness real-time e-markets\"\n"+
            "    }\n"+
            "  }";

    private static final String JSON_RESPONSE_USER_COLLECTION = "[{\n" +
            "    \"id\": 5,\n" +
            "    \"name\": \"Chelsey Dietrich\",\n" +
            "    \"username\": \"Kamren\",\n" +
            "    \"email\": \"Lucio_Hettinger@annie.ca\",\n" +
            "    \"address\": {\n" +
            "      \"street\": \"Skiles Walks\",\n" +
            "      \"suite\": \"Suite 351\",\n" +
            "      \"city\": \"Roscoeview\",\n" +
            "      \"zipcode\": \"33263\",\n" +
            "      \"geo\": {\n" +
            "        \"lat\": \"-31.8129\",\n" +
            "        \"lng\": \"62.5342\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"phone\": \"(254)954-1289\",\n" +
            "    \"website\": \"demarco.info\",\n" +
            "    \"company\": {\n" +
            "      \"name\": \"Keebler LLC\",\n" +
            "      \"catchPhrase\": \"User-centric fault-tolerant solution\",\n" +
            "      \"bs\": \"revolutionize end-to-end systems\"\n" +
            "    }\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"name\": \"Mrs. Dennis Schulist\",\n" +
            "    \"username\": \"Leopoldo_Corkery\",\n" +
            "    \"email\": \"Karley_Dach@jasper.info\",\n" +
            "    \"address\": {\n" +
            "      \"street\": \"Norberto Crossing\",\n" +
            "      \"suite\": \"Apt. 950\",\n" +
            "      \"city\": \"South Christy\",\n" +
            "      \"zipcode\": \"23505-1337\",\n" +
            "      \"geo\": {\n" +
            "        \"lat\": \"-71.4197\",\n" +
            "        \"lng\": \"71.7478\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"phone\": \"1-477-935-8478 x6430\",\n" +
            "    \"website\": \"ola.org\",\n" +
            "    \"company\": {\n" +
            "      \"name\": \"Considine-Lockman\",\n" +
            "      \"catchPhrase\": \"Synchronised bottom-line interface\",\n" +
            "      \"bs\": \"e-enable innovative applications\"\n" +
            "    }\n" +
            "  }]";
}