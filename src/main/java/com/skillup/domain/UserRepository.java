package com.skillup.domain;

import org.springframework.stereotype.Repository;

public interface UserRepository {
    void createUser(UserDomain userDomain);

    UserDomain getUserByUserName(String userName);

    UserDomain getUserByUserId(String userId);

    void updateUser(UserDomain userDomain);


}
