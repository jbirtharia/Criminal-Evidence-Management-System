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
public class Evidence extends AbstractEntity{

    private CriminalCase criminalCase;

    private Storage storage;

    private String number;

    private String itemName;

    private String notes;

    private Boolean archived = false;

    private Set<TrackEntry> trackEntries = new HashSet<>();
}
