package com.irisa.obiee.backforfront.cache.userprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public int add(UserProfile userProfile) {
        userProfileRepository.save(userProfile);
        return 1;
    }

    @Override
    public String getByUserName(String userName) throws EntityNotFoundException {
        UserProfile userProfile = userProfileRepository.getOne(userName);
        return userProfile.getValue();
    }
}
