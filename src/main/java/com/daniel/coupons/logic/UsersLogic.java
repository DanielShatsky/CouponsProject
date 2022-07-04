package com.daniel.coupons.logic;

import com.daniel.coupons.dto.User;
import com.daniel.coupons.entities.UserEntity;
import com.daniel.coupons.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersLogic {

    @Autowired
    private IUserRepository userRepository;

    public long createUser(User user){
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    public User getUserById(long id){
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User(userEntity);
        return user;
    }

    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user){
        UserEntity userEntity = new UserEntity(user);
        userRepository.save(userEntity);
    }
}
