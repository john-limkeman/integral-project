package com.integralproject.integralproject.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void UserShouldHaveGettersAndSetters(){
        User user = new User();
        Set<Integer> following = new HashSet<>();
        following.add(2);
        following.add(3);
        user.setUsername("john");
        user.setId(1);
        user.setPassword("password");
        user.setFollowing(following);

        assertEquals("john", user.getUsername());
        assertEquals(1, user.getId());
        assertEquals("password", user.getPassword());

        assertEquals(2, user.getFollowing().size());
        assertEquals(true, user.getFollowing().contains(3));

    }

}