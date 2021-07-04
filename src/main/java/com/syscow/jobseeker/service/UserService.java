package com.syscow.jobseeker.service;

import com.syscow.jobseeker.entity.User;
import com.syscow.jobseeker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(User user) {
        if (!userRepository.findName(user.getName()).isEmpty()) {
            throw new RuntimeException("User already exists");
        }
        user.setApiKey(UUID.randomUUID().toString());
        try {
            return userRepository.save(user).getApiKey();
        } catch (Exception ex) {
            throw new RuntimeException("User not created");
        }
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    public boolean isApiKeyValid(String apiKey) {
        return userRepository.findApiKey(apiKey).stream()
                .anyMatch(apiKeyEntity -> apiKeyEntity.getApiKey().equals(apiKey));
    }

}
