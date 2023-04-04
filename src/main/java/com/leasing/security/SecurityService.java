package com.leasing.security;
import com.leasing.domain.CreditCard;
import com.leasing.domain.User;
import com.leasing.domain.request.JwtAuthRequest;
import com.leasing.domain.request.RegistrationUser;
import com.leasing.domain.response.JwtResponse;
import com.leasing.repository.UserRepository;
import com.leasing.security.jwt.JwtProvider;
import com.leasing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SecurityService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    //    public String getToken(JwtAuthRequest jwtAuthRequest){
//        Optional<User> user = userRepository.findUserByLogin(jwtAuthRequest.getLogin());
//        if(user.isPresent() && passwordEncoder.matches(jwtAuthRequest.getPassword(), user.get().getPassword())){
//            return jwtProvider.createJwtToken(jwtAuthRequest.getLogin());
//        }
//        return "";
//    }
    @Transactional(rollbackFor = Exception.class)
    public boolean registrationUser(RegistrationUser registrationUser) {
        try {
            User user = new User();
            user.setFirstName(registrationUser.getFirstName());
            user.setLastName(registrationUser.getLastName());
            user.setLogin(registrationUser.getLogin());
            user.setPassword(passwordEncoder.encode(registrationUser.getPassword()));

            User savedUser = userRepository.save(user);
            userRepository.addUserRole(user.getId());

            if (savedUser != null) {
                return true;
            }
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return false;
    }
}
