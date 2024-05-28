package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.UserService;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//public class UserControllerTest {
//
//    @InjectMocks
//    UserController userController;
//
//    @Mock
//    UserService userService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetUserById() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("Test User");
//
//        when(userService.getUserById(1L)).thenReturn(user);
//
//        User foundUser = userController.getUserById(1L);
//
//        assertEquals(user, foundUser);
//    }
//
//    @Test
//    public void testCreateUser() {
//        User user = new User();
//        user.setName("Test User");
//
//        when(userService.createUser(user)).thenReturn(user);
//
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        ResponseEntity<User> responseEntity = userController.createUser(user);
//
//        assertEquals(201, responseEntity.getStatusCodeValue());
//        assertEquals("/api/users/1", responseEntity.getHeaders().getLocation().getPath());
//    }
//}