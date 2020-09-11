package com.irisa.obiee.backforfront.userprofiles.service;


import com.irisa.obiee.backforfront.userprofiles.model.UserProfile;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface UserProfileService {
     int add(UserProfile userProfile);
     String getByUserName(String userName) throws EntityNotFoundException;

}
