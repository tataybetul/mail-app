package com.betul.mailapp.service;

import com.betul.mailapp.entity.MailEntity;
import com.betul.mailapp.entity.UserEntity;
import com.betul.mailapp.exception.MailGenericException;
import com.betul.mailapp.exception.UserNotFoundException;
import com.betul.mailapp.mapper.MailMapper;
import com.betul.mailapp.model.Mail;
import com.betul.mailapp.model.MailCreateRequest;
import com.betul.mailapp.repository.MailRepository;
import com.betul.mailapp.repository.UserRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

    private final MailRepository mailRepository;
    private final UserRepository userRepository;
    private final MailMapper mailMapper;

    public void create(MailCreateRequest mailCreateRequest) {
        try {
            UserEntity senderUser = userRepository.findByEmail(mailCreateRequest.getSenderUser());
            if (senderUser == null) {
                throw new UserNotFoundException("Sender User not found, Sender User Mail: " + mailCreateRequest.getSenderUser());
            }
            List<UserEntity> replyToUsers = findByEmailIn(mailCreateRequest.getReplyToUsers());
            MailEntity mailEntity = mailMapper.mapToEntity(senderUser, replyToUsers, mailCreateRequest.getSubject(), mailCreateRequest.getBody());
            mailRepository.save(mailEntity);
            log.info("Created new MAIL {}", mailCreateRequest);
        } catch (UserNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("An error occurred when creating Mail", e);
            throw new MailGenericException("An error occurred when creating Mail", e);
        }
    }

    private List<UserEntity> findByEmailIn(List<String> replyToUsers) {
        List<UserEntity> userEntities = Lists.newArrayList();
        for (String userEmail : replyToUsers) {
            UserEntity userEntity = userRepository.findByEmail(userEmail);
            if (userEntity == null) {
                log.error("An Error occurred when searching by email {}", userEmail);
                throw new UserNotFoundException("User not found by email: " + userEmail);
            }
            userEntities.add(userEntity);
        }
        return userEntities;
    }

    public List<Mail> getAll() {
        try {
            List<MailEntity> mailEntities = mailRepository.findAll();
            return mailMapper.mapToModels(mailEntities);
        } catch (Exception e) {
           log.error("An error occurred when getting All Mails", e);
           throw new MailGenericException("An error occurred when getting All Mails", e);
        }
    }
}
