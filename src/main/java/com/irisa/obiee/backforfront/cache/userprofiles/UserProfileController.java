package com.irisa.obiee.backforfront.cache.userprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(value = "/getByUser/{userName}",method = RequestMethod.GET)
    public ResponseEntity<String> getByUser(@PathVariable String userName) {
        try {
            String userNameValue = userProfileService.getByUserName(userName);
            return new ResponseEntity<>(userNameValue,HttpStatus.OK);
        }catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
