package com.irisa.obiee.backforfront.userprofiles.controller;

import com.irisa.obiee.backforfront.userprofiles.model.UserProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserProfileController {

     ResponseEntity<String> getByUser(@PathVariable String userName) ;

}
