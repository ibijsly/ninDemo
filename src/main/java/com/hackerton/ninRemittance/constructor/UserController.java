package com.hackerton.ninRemittance.constructor;

import com.hackerton.ninRemittance.model.ResponseModel;
import com.hackerton.ninRemittance.model.UserDetails;
import com.hackerton.ninRemittance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<ResponseModel> add(@RequestBody UserDetails userDetails){
        return userService.addUser(userDetails);
    }


}
