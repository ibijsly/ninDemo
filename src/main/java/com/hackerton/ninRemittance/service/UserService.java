package com.hackerton.ninRemittance.service;

import com.hackerton.ninRemittance.dao.UserDetailsDao;
import com.hackerton.ninRemittance.model.ResponseModel;
import com.hackerton.ninRemittance.model.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {
    private final UserDetailsDao userDetailsDao;

    public UserService(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    public ResponseEntity<ResponseModel> addUser(UserDetails userDetails){
        try {
            userDetails.setPhoto(Base64.getDecoder().decode(userDetails.getPix().getBytes("UTF-8")));
            userDetailsDao.save(userDetails);
            return new ResponseEntity<>(new ResponseModel("00", "Success", userDetails), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ResponseModel("99", "Failed", null), HttpStatus.BAD_REQUEST);
        }
    }

    public UserDetails findByPhoneAndEmail(String phone, String email){
        try {
            return userDetailsDao.findByPhoneAndEmail(phone, email);
        }catch (Exception ex){
            return null;
        }
    }

    public UserDetails findByNin(String nin){
        return userDetailsDao.findByNin(nin);
    }
}
