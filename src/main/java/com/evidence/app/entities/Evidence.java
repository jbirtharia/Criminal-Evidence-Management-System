package com.evidence.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Setter
@Getter
@SequenceGenerator(name = "seqEvidenceGen", allocationSize = 1)
@Entity
public class Evidence extends AbstractEntity{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "case_fk", nullable = false)
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_fk", nullable = false)
    private Storage storage;

    @NotEmpty
    @Column(name= "evidence_number", unique = true, nullable = false)
    private String number;

    @NotEmpty
    private String itemName;

    //very big text
    private String notes;

    private Boolean archived = false;

    @OneToMany(mappedBy = "evidence", cascade = CascadeType.PERSIST)
    private Set<TrackEntry> trackEntries = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var evidence = (Evidence) o;
        return Objects.equals(criminalCase, evidence.criminalCase) &&
                Objects.equals(number, evidence.number) &&
                Objects.equals(itemName, evidence.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), criminalCase, number, itemName);
    }

}
