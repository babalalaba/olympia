package com.newer.olympia.controller;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:07
 * */

import com.newer.olympia.domain.*;
import com.newer.olympia.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/AlbumAlls")
    public ResponseEntity<?> AlbumAlls(Integer User_id){
        List<Album> albums = hobbiesService.AlbumAll(User_id);
        System.out.println(albums+"相册");
        return new ResponseEntity<>(albums,HttpStatus.OK);
    }
    @GetMapping("/FriendAll")
    public ResponseEntity<?> FriendAll(Integer User_id){
        List<Friend> friends = hobbiesService.FriendAll(User_id);
        return new ResponseEntity<>(friends,HttpStatus.OK);
    }
    //好友数量
    @GetMapping("/FriendSize")
    public ResponseEntity<?> FriendSize(Integer User_id){
        List<Friend> friends = hobbiesService.FriendAll(User_id);
        return new ResponseEntity<>(friends.size(),HttpStatus.OK);
    }
    @GetMapping("/MedalAll")
    public ResponseEntity<?> MedalAll(Integer User_id){
        List<Medal_user> medal_users = hobbiesService.MedalAll(User_id);
        System.out.println(medal_users+"1314");
        return new ResponseEntity<>(medal_users,HttpStatus.OK);
    }
}
