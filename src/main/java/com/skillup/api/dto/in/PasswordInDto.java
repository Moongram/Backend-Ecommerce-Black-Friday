package com.skillup.api.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PasswordInDto {
    private String userId;
    @NotNull(message = "Old Password cannot be null.")
    private String oldPassword;
    @NotNull(message = "New Password cannot be null.")
    private String newPassword;
}
