package com.movies.Movies.service;


import com.movies.Movies.model.UserModel;
import com.movies.Movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
       return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> findUserById(long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> findByRole(int role){
        return userRepository.findByRole(role);
    }

    public boolean deleteUser(long id){
        try{
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
