package com.skillup.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDomain {
    private String userId;
    private String userName;
    private String password;
}
