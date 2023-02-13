package com.ProjetSpring.ProjetSpring.Service;

import com.ProjetSpring.ProjetSpring.UserRepository;
import com.ProjetSpring.ProjetSpring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{ //Added this whole package§
    /**/
    @Autowired
    private UserRepository userRepo;
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return userRepo.existsByUsername(username);
    }


}
