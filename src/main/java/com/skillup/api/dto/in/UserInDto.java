package com.skillup.api.dto.in;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInDto {

    private String userName;
    private String password;

}
