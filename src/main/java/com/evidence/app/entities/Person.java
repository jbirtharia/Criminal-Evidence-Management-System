package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person extends AbstractEntity{

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private LocalDateTime hiringDate;

    private String newPassword;

}
