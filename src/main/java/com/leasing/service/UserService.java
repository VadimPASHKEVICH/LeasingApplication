package com.leasing.service;
import com.leasing.domain.User;
import com.leasing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {

    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public void createUser(User user){userRepository.save(user);}
    public void updateUser(User user){userRepository.saveAndFlush(user);}
    public ArrayList<User> getAllUsers() {return (ArrayList<User>) userRepository.findAll();}

    public User getUserById(int id){return userRepository.findById(id).get();}
    public void deleteUser (User user){userRepository.delete(user);}
}