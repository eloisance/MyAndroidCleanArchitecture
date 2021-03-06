/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package project.eloisance.com.data.net;

import java.util.List;

import io.reactivex.Observable;
import project.eloisance.com.data.entity.UserEntity;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {

    String API_BASE_URL = "https://jsonplaceholder.typicode.com/";
    String API_URL_GET_USER_LIST = API_BASE_URL + "users";
    String API_URL_GET_USER_DETAILS = API_BASE_URL + "users/";

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Retrieves an {@link Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id used to get user data.
     */
    Observable<UserEntity> userEntityById(final int userId);
}
