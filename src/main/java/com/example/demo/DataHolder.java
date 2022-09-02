package com.example.demo;

import com.example.demo.Model.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        User user1 = new User("Enis","enis","nisizenuni@gmail.com","070951601");
        users.add(user1);
    }

}

