package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private HashService hashService;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userMapper, hashService);
    }

    @Test
    void deleteUser_delegatesToMapper() {
        String username = "vinushas";

        userService.deleteUser(username);

        verify(userMapper, times(1)).deleteUser(username);
    }
}
