package com.example.demo.Service;

import com.example.demo.Model.Exceptions.InvalidArgumentsException;
import com.example.demo.Model.Exceptions.InvalidUserCredentialsException;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserInMemoryRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final UserInMemoryRepository userInMemoryRepository;

    public AuthServiceImpl(UserInMemoryRepository userInMemoryRepository) {
        this.userInMemoryRepository = userInMemoryRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username.isEmpty()|| password.isEmpty())
            throw new InvalidArgumentsException();
        return userInMemoryRepository.findByUserNameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username,String password,String email,String number) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()  || number.isEmpty())
            throw new InvalidArgumentsException();
        User newUser = new User(username,password,email,number);
        return  userInMemoryRepository.saveOrUpdate(newUser);
    }
}
