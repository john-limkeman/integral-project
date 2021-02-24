package com.integralproject.integralproject.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    public void PostShouldHaveGettersAndSetters(){
        Post post = new Post();
        Date date = new Date();

        post.setId(1);
        post.setUser_id(3);
        post.setPostingTime(date);
        post.setContent("This is a test");

        assertEquals(1, post.getId());
        assertEquals(3, post.getUser_id());
        assertEquals(date, post.getPostingTime());
        assertEquals("This is a test", post.getContent());

    }


}