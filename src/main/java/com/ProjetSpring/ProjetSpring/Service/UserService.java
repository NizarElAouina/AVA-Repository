package com.ProjetSpring.ProjetSpring.Service;
import com.ProjetSpring.ProjetSpring.model.User;
import org.springframework.context.annotation.Bean;

public interface UserService {

    //Added this whole package

    /**/
    @Bean
    public User createUser(User user);
    public boolean checkUsername(String username);


}
