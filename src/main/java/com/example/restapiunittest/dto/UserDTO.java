package com.example.restapiunittest.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDTO {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

}
