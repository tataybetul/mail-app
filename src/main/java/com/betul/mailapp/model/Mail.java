package com.betul.mailapp.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class Mail {

    private Long id;
    private User senderUser;
    private List<User> replyToUsers;
    private String subject;
    private String body;
    private Date createdDate;
    private Date sendDate;
}
