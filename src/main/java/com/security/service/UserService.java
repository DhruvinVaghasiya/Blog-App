package com.security.service;

import com.security.model.UserDtls;

public interface UserService {
    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);
}
