package com.hackerton.ninRemittance.constructor;

import com.hackerton.ninRemittance.model.ResponseModel;
import com.hackerton.ninRemittance.model.UserDetails;
import com.hackerton.ninRemittance.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/fetch/{type}/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseModel> fetch(@PathVariable(name = "type", required = true) String type, @PathVariable(name = "id", required = true) String id){
        try {
            int idType = 0;
            if (type.equalsIgnoreCase("nin"))
                idType = 0;
            else if (type.equalsIgnoreCase("vin"))
                idType = 1;
            else
                return new ResponseEntity<ResponseModel>(new ResponseModel("02", "Unknown Type", null), HttpStatus.NOT_FOUND);

            UserDetails userDetails = null;
            switch (idType){
                case 0:
                    userDetails = userService.findByNin(id);
                    break;

                case 1:
                    userDetails = userService.findByVin(id);
                    break;

                default:
                    return new ResponseEntity<ResponseModel>(new ResponseModel("02", "Unknown Type", null), HttpStatus.NOT_FOUND);

            }

            if (userDetails == null)
                return new ResponseEntity<ResponseModel>(new ResponseModel("02", "Not Found", null), HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ResponseModel>(new ResponseModel("00", "Success", userDetails), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<ResponseModel>(new ResponseModel("99", "Error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/all")
    public ResponseEntity<ResponseModel> all(){
        return new ResponseEntity<ResponseModel>( new ResponseModel("00", "Success", userService.allUsers()), HttpStatus.OK);
    }

}
