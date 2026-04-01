package com.example.myTaskManager.seeder;

import com.example.myTaskManager.dto.request.UserRequestDTO;
import com.example.myTaskManager.entity.User;
import com.example.myTaskManager.mapper.UserMapper;
import com.example.myTaskManager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            UserRequestDTO user1DTO = new UserRequestDTO("saraTijhuis", "sara_thijhuis@gamil.com", "12345");
            UserRequestDTO user2DTO = new UserRequestDTO("johnDoe", "john@example.com", "678910");
            User user1 = UserMapper.toEntity(user1DTO);
            User user2 = UserMapper.toEntity(user2DTO);
            userRepository.saveAll(List.of(user1, user2));
        }
    }
}
