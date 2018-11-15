package com.betul.mailapp.model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateRequest {

    private String firstName;
    private String lastName;
    private String email;
}
