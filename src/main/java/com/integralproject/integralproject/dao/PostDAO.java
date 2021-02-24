package com.integralproject.integralproject.dao;

import com.integralproject.integralproject.model.Post;

import java.util.List;

public interface PostDAO {

    public void addPost(Post post);

    public void deletePost(Post post);

    public List<Post> getAllPostById(int id);

}
