package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostJdbcDAO implements  PostDAO{
    private JdbcTemplate jdbc;

    PostJdbcDAO(DataSource dataSource){
        this.jdbc = new JdbcTemplate(dataSource);
    }


    @Override
    public void addPost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }

    @Override
    public List<Post> getAllPostById(int id) {
        List<Post> allPosts = new ArrayList<>();
    String sql = "SELECT * FROM Posts WHERE id = ?";
        SqlRowSet result = jdbc.queryForRowSet(sql, id);
        while (result.next()) {
            Post post = mapRowToPost(result);
            allPosts.add(post);
        }
        return allPosts;
    }

    public Post mapRowToPost(SqlRowSet row){
        Post post = new Post();
        post.setContent(row.getString("content"));
        post.setPostingTime(row.getDate("postingTime"));
        post.setUser_id(row.getInt("user_id"));
        post.setId(row.getInt("id"));

        return post;
    }
}
