package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage extends AbstractEntity{

    private String name;

    private String location;

    private Set<Evidence> evidenceSet = new HashSet<>();

}
