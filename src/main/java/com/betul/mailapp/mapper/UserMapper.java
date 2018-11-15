package com.betul.mailapp.mapper;

import com.betul.mailapp.entity.UserEntity;
import com.betul.mailapp.model.User;
import com.betul.mailapp.model.UserCreateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .createdDate(userEntity.getCreatedDate())
                .updatedDate(userEntity.getUpdatedDate())
                .enabled(userEntity.isEnabled())
                .build();
    }

    public List<User> mapToModels(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public UserEntity mapToEntity(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userCreateRequest.getFirstName());
        userEntity.setLastName(userCreateRequest.getLastName());
        userEntity.setEmail(userCreateRequest.getEmail());
        Date date = new Date();
        userEntity.setCreatedDate(date);
        userEntity.setUpdatedDate(date);
        userEntity.setEnabled(true);
        return userEntity;
    }
}
