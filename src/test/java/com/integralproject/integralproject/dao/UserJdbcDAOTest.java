package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.User;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserJdbcDAOTest {
    private static SingleConnectionDataSource dataSource;
    private UserJdbcDAO dao;
    User testUser = new User();


    @BeforeAll
    public static void setupDataSource() {
        //connects the test database
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/integral-project-test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }
    @BeforeEach
    public void setup(){
        Set<Integer> following = new HashSet<>();
        following.add(2);
        following.add(3);
        testUser.setUsername("testUsername");
        testUser.setPassword("testPassword");
        testUser.setFollowing(following);


        dao = new UserJdbcDAO(dataSource);
    }
    @AfterEach
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @AfterAll
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @Test
    public void getAllFollowingOf1ShouldReturn3(){
        Set<Integer> returned = dao.getAllFollowingById(1);

        assertEquals(3, returned.size());
    }


    @Test
    public void getAllUsersShouldReturn4(){
        List<User> returned = dao.getAllUsers();

        assertEquals(4, returned.size());
    }

    @Test
    public void getUserByIdShouldReturn1(){

        User returned = dao.getUserById(1);

        assertEquals(1, returned.getId());
        assertEquals("john", returned.getUsername());

    }

    @Test
    public void addUserShouldReturn5(){
        dao.addUser(testUser);
        List<User> returned = dao.getAllUsers();

        assertEquals(5, returned.size());
    }

    @Test
    public void deleteUserShouldReturn3(){
        dao.deleteUserById(1);

        List<User> returned = dao.getAllUsers();

        assertEquals(3, returned.size());
    }

    @Test
    public void updateUserShouldChangeDataToTestData(){
        dao.updateUserById(testUser, 1);

        User returned = dao.getUserById(1);

        assertEquals("testUsername", returned.getUsername());
    }



}