package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Detective extends AbstractEntity{

    private Person person;

    private String badgeNumber;

    private Rank rank;

    private Boolean armed = false;
}
