package com.leasing.security;
import com.leasing.domain.User;
import com.leasing.domain.request.JwtAuthRequest;
import com.leasing.domain.request.RegistrationUser;
import com.leasing.domain.response.JwtResponse;
import com.leasing.repository.UserRepository;
import com.leasing.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SecurityService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Autowired
    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }
    public String getToken(JwtAuthRequest jwtAuthRequest){
        Optional<User> user = userRepository.findUserByLogin(jwtAuthRequest.getLogin());
        if(user.isPresent() && passwordEncoder.matches(jwtAuthRequest.getPassword(), user.get().getPassword())){
            return jwtProvider.createJwtToken(jwtAuthRequest.getLogin());
        }
        return "";
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean registration(RegistrationUser registrationUser) {
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
            System.out.println(exception);
        }
        return false;
    }
}
