package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserJdbcDAO implements UserDAO{
    private JdbcTemplate jdbc;

    UserJdbcDAO(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public Set<Integer> getAllFollowingById(int id){
        Set<Integer> followingSet = new HashSet<>();
        String sql = "SELECT following_id FROM Followings WHERE follower_id = ?";
        SqlRowSet result = jdbc.queryForRowSet(sql, id);
        while(result.next()){
            int followed = result.getInt("following_id");
            followingSet.add(followed);
        }
        return followingSet;
    }



    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        SqlRowSet result = jdbc.queryForRowSet(sql);
        while (result.next()){
            User user = mapRowToUser(result);
            users.add(user);
        }
        for (User user: users){
            user.setFollowing(getAllFollowingById(user.getId()));
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void updateUserById(User user, int id) {

    }

    public User mapRowToUser(SqlRowSet row){
        User user = new User();
        user.setUsername(row.getString("username"));
        user.setPassword(row.getString("password"));
        return user;
    }

}
