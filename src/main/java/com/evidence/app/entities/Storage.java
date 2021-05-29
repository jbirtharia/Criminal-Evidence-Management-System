package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seqStorageGen", allocationSize = 1)
@Entity
public class Storage extends AbstractEntity{

    @NotNull
    @Size(min = 8, max = 30)
    private String name;

    @NotNull
    @Size(min = 8, max = 150)
    private String location;

    @OneToMany(mappedBy = "storage")
    private Set<Evidence> evidenceSet = new HashSet<>();

}
