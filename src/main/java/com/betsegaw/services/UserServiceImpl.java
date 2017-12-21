package com.betsegaw.services;

import com.betsegaw.entities.User;
import com.betsegaw.exception.NotFoundException;
import com.betsegaw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For ID value: "+userId.toString());
        }
        return userOptional.get();
    }

    @Override
    public User findByUserName(String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if(!userOptional.isPresent()){
            throw new NotFoundException("User Not Found. For User Name value: "+userName);
        }
        return userOptional.get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
