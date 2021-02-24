package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {

    public Set<Integer> getAllFollowingById(int id);

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void addUser(User user);

    public void deleteUserById(int id);

    public void updateUserById(User user, int id);

}
