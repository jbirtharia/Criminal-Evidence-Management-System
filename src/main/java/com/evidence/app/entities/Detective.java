package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seqDetectiveGen", allocationSize = 1)
@Entity
public class Detective extends AbstractEntity{

    @NotNull
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String badgeNumber;

    @NotNull
    @Column(name = "detective_rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    @Column
    private Boolean armed = false;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="case_id", referencedColumnName="id"))
    private Set<CriminalCase> criminalCases = new HashSet<>();

    @OneToMany(mappedBy = "detective")
    private Set<TrackEntry> trackEntries;

}
