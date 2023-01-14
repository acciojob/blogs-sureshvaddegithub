package com.driver.services;



import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    private BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image image = new Image(description,dimensions);

        image.setBlog(blog);
        List<Image> imagesList =blog.getImageList();
        if(imagesList == null){
            imagesList = new ArrayList<>();
        }
        imagesList.add(image);
        blog.setImageList(imagesList);
        imageRepository2.save(image);
        blogRepository.save(blog);
        //ImageResponseDto imageResponseDto = new ImageResponseDto(image.getId(), image.getDescription(), image.getDimensions());
        return image;
    }

    public void deleteImage(Image image){
    imageRepository2.delete(image);
    }

    public Image findById(int id) {
       return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        if(image==null){
            return 0;
        }
        String s = image.getDimensions();

        int ans = screenSize(s)/screenSize(screenDimensions);
        return ans;



    }
    public int screenSize(String s){
        int  screenSize = 0;
        int i = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            screenSize=screenSize*10+s.charAt(i)-'0';
            i++;
        }
        screenSize =screenSize*Integer.parseInt(s.substring(i+1,s.length()));
        return screenSize;
    }
}
