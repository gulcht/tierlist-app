package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.User;
import com.mobile101.tierlistAPI.tierlist.repository.UserRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.IUser;

@Service
public class UserService implements IUser{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
       return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
       return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
       userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findOptionalById(long id) {
        return userRepository.findOptionalById(id);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            user.setPassword("");
            return user;
        }
        return null;
    }
    

}
