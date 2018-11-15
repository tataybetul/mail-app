package com.betul.mailapp.mapper;

import com.betul.mailapp.entity.MailEntity;
import com.betul.mailapp.entity.UserEntity;
import com.betul.mailapp.model.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MailMapper {

    private final UserMapper userMapper;

    public MailEntity mapToEntity(UserEntity senderUser, List<UserEntity> replyToUserEntities, String subject, String body) {
        MailEntity mailEntity = new MailEntity();
        mailEntity.setSenderUserEntity(senderUser);
        mailEntity.setReplyToUserEntity(replyToUserEntities);
        mailEntity.setSubject(subject);
        mailEntity.setBody(body);
        mailEntity.setCreatedDate(new Date());
        return mailEntity;
    }

    public Mail mapToModel(MailEntity mailEntity) {

        return Mail.builder()
                .id(mailEntity.getId())
                .body(mailEntity.getBody())
                .subject(mailEntity.getSubject())
                .senderUser(userMapper.mapToModel(mailEntity.getSenderUserEntity()))
                .replyToUsers(userMapper.mapToModels(mailEntity.getReplyToUserEntity()))
                .createdDate(mailEntity.getCreatedDate())
                .sendDate(mailEntity.getSendDate())
                .build();
    }

    public List<Mail> mapToModels(List<MailEntity> mailEntities) {

        return mailEntities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }
}
