package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByUsername_returnsUser() {
        User user = User.builder().id(1L).username("test").password("pass").role("USER").build();
        when(userRepository.findByUsername("test")).thenReturn(Optional.of(user));
        Optional<User> found = userService.findByUsername("test");
        assertTrue(found.isPresent());
        assertEquals("test", found.get().getUsername());
    }
}
