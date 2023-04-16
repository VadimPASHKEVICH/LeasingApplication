package service;

import com.leasing.domain.User;
import com.leasing.repository.UserRepository;
import com.leasing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private User user;

    private List<User> users;

    @BeforeEach
    void setUser() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, passwordEncoder);
        user = new User(1, "user1", "password1", "userName", "userLastName");
        users = new ArrayList<>();
        users.add(user);
        userRepository.save(user);
    }

    @Test
    void getUserById() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        Optional<User> optionalArticle = Optional.ofNullable(userService.getUserById(user.getId()));

        assertTrue(optionalArticle.isPresent());
        verify(userRepository, times(1)).findById(user.getId());
    }

    @Test
    void getAllUser() {
        when(userRepository.findAll()).thenReturn(users);
        Optional<List<User>> optionalBooks = Optional.ofNullable(userService.getAllUsers());

        assertTrue(optionalBooks.isPresent());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void updateUser() {
        userService.updateUser(user);

        verify(userRepository, times(1)).save(any(User.class));
    }
}

