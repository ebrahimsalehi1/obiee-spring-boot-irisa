package com.irisa.obiee.backforfront.cache.userprofiles;


import javax.persistence.EntityNotFoundException;

public interface UserProfileService {
     int add(UserProfile userProfile);
     String getByUserName(String userName) throws EntityNotFoundException;

}
