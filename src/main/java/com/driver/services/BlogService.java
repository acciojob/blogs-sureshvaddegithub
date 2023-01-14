package com.driver.services;

import com.driver.BlogsApplication;
import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public int showBlogs(){
        //find all blogs
        return blogRepository1.findAll().size();

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time

        //updating the blog details

        //Updating the userInformation and changing its blogs

        Blog blog = new Blog(title,content);
        User user = userRepository1.findById(userId).get();
        blog.setUser(user);
        user.getListOfBlog().add(blog);
        blogRepository1.save(blog);
        userRepository1.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Image image = new Image(description,dimensions);
        Blog blog = blogRepository1.findById(blogId).get();
        image.setBlog(blog);
        blog.getListOfImages().add(image);
        blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Blog blog = blogRepository1.findById(blogId).get();
        User user = blog.getUser();
        for(int i = 0;i<user.getListOfBlog().size();i++){
            if(user.getListOfBlog().get(i).getId() == blogId)
                user.getListOfBlog().remove(i);
        }
        blogRepository1.deleteById(blogId);
    }
}
