package controller;

import com.leasing.domain.User;
import com.leasing.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserService userService;

    private User user;

    private List<User> userList;

    @BeforeEach
    void setUser() {
        user = new User(1, "user1", "password1", "userName", "userLastName");
        userList = new ArrayList<>();
        userList.add(user);
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    void getAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn((ArrayList<User>) userList);
        this.mockMvc.perform(get("/user/all",userList))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].id", is(user.getId())));
    }
    @Test
    @WithMockUser(username = "user", password = "user", roles = "ADMIN")
    void getUserById() throws Exception {
        when(userService.getUserById(user.getId())).thenReturn(user);
        this.mockMvc.perform(get("/user/{id}", user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].id", is(user.getId())));
    }
}