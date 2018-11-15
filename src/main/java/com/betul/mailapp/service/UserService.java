package com.betul.mailapp.service;

import com.betul.mailapp.entity.UserEntity;
import com.betul.mailapp.exception.UserAlreadyException;
import com.betul.mailapp.exception.UserGenericException;
import com.betul.mailapp.mapper.UserMapper;
import com.betul.mailapp.model.User;
import com.betul.mailapp.model.UserCreateRequest;
import com.betul.mailapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void create(UserCreateRequest userCreateRequest) {
        try {
            UserEntity foundUser = userRepository.findByEmail(userCreateRequest.getEmail());
            if (foundUser != null) {
                log.error("User already exist, Email: {}", userCreateRequest.getEmail());
                throw new UserAlreadyException("User already exist, Email: " + userCreateRequest.getEmail());
            }
            UserEntity userEntity = userMapper.mapToEntity(userCreateRequest);
            userRepository.save(userEntity);
            log.info("Created new USER {}", userCreateRequest);
        } catch (UserAlreadyException e) {
            throw e;
        }
        catch (Exception e) {
            log.error("An error occurred when creating User", e);
            throw new UserGenericException("An error occurred when creating User", e);
        }
    }

    public List<User> getAll() {
        try {
            List<UserEntity> userEntities = userRepository.findAll();
            return userMapper.mapToModels(userEntities);
        } catch (Exception e) {
            log.error("An error occurred when getting All Users", e);
            throw new UserGenericException("An error occurred when getting All Users", e);
        }
    }
}
