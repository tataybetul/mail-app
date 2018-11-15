package com.betul.mailapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MailCreateRequest {

    private String senderUser;
    private List<String> replyToUsers;
    private String subject;
    private String body;
}
