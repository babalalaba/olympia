package com.newer.olympia.controller;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:07
 * */

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Hobbies;
import com.newer.olympia.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class HobbiesController {
    @Autowired
    private HobbiesService hobbiesService;
    @PostMapping("/HobbiesAll")
    public ResponseEntity<?> HobbiesAll(Integer User_id){
        List<Hobbies> hobbies = hobbiesService.hobbiesAll(User_id);
        System.out.println(hobbies);
        return new ResponseEntity<>(hobbies,HttpStatus.OK);
    }
    @PostMapping("/BlogsAlls")
    public ResponseEntity<?> BlogsAlls(Integer User_id){
        List<Blogs> blogs = hobbiesService.BlogsAll(User_id);
        System.out.println(blogs+"????????????");
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
