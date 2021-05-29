package com.evidence.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JayendraB
 * Created on 26/05/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

}
