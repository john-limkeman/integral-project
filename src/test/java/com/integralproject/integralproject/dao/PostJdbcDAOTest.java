package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.Post;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.swing.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PostJdbcDAOTest {

    private Post testPost = new Post();
    private PostJdbcDAO dao;
    private static SingleConnectionDataSource dataSource;

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
    public void setup() {
        dao = new PostJdbcDAO(dataSource);
        testPost.setContent("sample");
        testPost.setUser_id(1);
        testPost.setPostingTime(new Date());

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
    public void addPostShouldIncreasePostTotal(){
        List<Post> beforeTest = dao.getAllPostById(1); //1 is testPost user_id
        dao.addPost(testPost);
        List<Post> afterTest = dao.getAllPostById(1);

        int diff = afterTest.size() - beforeTest.size();

        assertEquals(1, diff);


    }
}
