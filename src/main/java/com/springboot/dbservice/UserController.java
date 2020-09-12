package com.springboot.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${postgresql.service.host:default}")
    String postgresqlServiceHost;

    @PostMapping(value = "/user", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity save(@RequestBody UserInfo userInfo) {
        userService.save(userInfo);
        return new ResponseEntity("Record saved!", HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity getUsers() {
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "test")
    public void testApp() {
        System.out.println("Testing application!");
        System.out.println(postgresqlServiceHost);
    }
}
