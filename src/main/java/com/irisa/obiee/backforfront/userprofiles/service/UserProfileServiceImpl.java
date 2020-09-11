package com.irisa.obiee.backforfront.userprofiles.service;

import com.irisa.obiee.backforfront.userprofiles.model.UserProfile;
import com.irisa.obiee.backforfront.userprofiles.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
