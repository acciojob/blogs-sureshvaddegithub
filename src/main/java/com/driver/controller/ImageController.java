package com.driver.controller;

import com.driver.RequestDtos.BlogRequestDto;
import com.driver.ResponseDto.ImageResponseDto;
import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.repositories.ImageRepository;
import com.driver.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/create")
    public ResponseEntity<ImageResponseDto> createAndReturn(@RequestBody BlogRequestDto blogRequestDto,
                                                            @RequestParam String description,
                                                            @RequestParam String dimensions) {
        ImageResponseDto imageResponseDto=imageService.createAndReturn(blogRequestDto,description,dimensions);
        return new ResponseEntity<>(imageResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/countImagesInScreen/{id}/{screenDimensions}")
    public ResponseEntity<Integer> countImagesInScreen(@PathVariable int id, @PathVariable String screenDimensions){

        int count = imageService.countImagesInScreen(id,screenDimensions);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable int id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



