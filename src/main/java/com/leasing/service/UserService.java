package com.leasing.service;

import com.leasing.domain.Agreement;
import com.leasing.domain.User;
import com.leasing.repository.AgreementRepository;
import com.leasing.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AgreementRepository agreementRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserService(UserRepository userRepository, AgreementRepository agreementRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.agreementRepository = agreementRepository;
    }

    public User getUserByLogin() {
        return userRepository.findUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public boolean updateUser(User user) {
        if (getUserByLogin().getId() == user.getId()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserById(int id) {
        try {
            User user = userRepository.findById(id).get();
            if (user == null) {
                throw new NoSuchElementException();
            } else {
                return user;
            }
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
        }
        return new User();
    }

    public boolean deleteUserById(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Agreement> getAllAgreementDebtByUserId(){
        return agreementRepository.getAgreementDebtByUserId(getUserByLogin().getId());
    }
}
