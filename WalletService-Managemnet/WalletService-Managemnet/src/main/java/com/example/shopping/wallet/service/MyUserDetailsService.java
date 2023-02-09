package com.example.shopping.wallet.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.shopping.wallet.models.User1;
import com.example.shopping.wallet.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User1 user =repository.findByUsername(username);
        if(user==null)
        {
            return null;
        }
        String name = user.getUsername();
        String pwd = user.getPassword();

 

        return new User(name, pwd, new ArrayList<>());

 

    }
}
