package com.betsegaw.services;


import com.betsegaw.entities.User;

import java.util.Set;

public interface UserService {
    public Set<User> getUsers();
    public User findById(Long userId);
    public User findByUserName(String firstName);
    public User saveUser(User user);
    public void deleteById(Long userId);
}
