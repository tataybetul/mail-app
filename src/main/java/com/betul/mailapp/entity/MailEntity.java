package com.betul.mailapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "sender_user_id")
    private UserEntity senderUserEntity;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mail_replytousers", joinColumns = @JoinColumn(name = "mail_id"), inverseJoinColumns = @JoinColumn(name = "reply_to_user_id"))
    private List<UserEntity> replyToUserEntity;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_date")
    private Date sendDate;
}
