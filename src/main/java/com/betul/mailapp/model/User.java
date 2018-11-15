package com.betul.mailapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdDate;
    private Date updatedDate;
    private boolean enabled;
}
