package com.irisa.obiee.backforfront.userprofiles.repository;

import com.irisa.obiee.backforfront.userprofiles.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,String>,CrudRepository<UserProfile,String> {

    @Override
    UserProfile getOne(String s);

    @Override
    boolean existsById(String s);

    @Override
    <S extends UserProfile> S save(S s);
}
