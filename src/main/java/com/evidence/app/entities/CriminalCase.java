package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Setter
@Getter
@AllArgsConstructor
@SequenceGenerator(name = "seqCriminalCaseGen", allocationSize = 1)
@Entity
public class CriminalCase extends AbstractEntity{

    @NotEmpty
    @Column(name="case_number", unique = true, nullable = false)
    private String number;

    @NotNull
    @Column(name="case_type")
    @Enumerated(EnumType.STRING)
    private CaseType type;

    @NotEmpty
    @Column(name="short_description")
    private String shortDescription;


    private String detailedDescription;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.PERSIST)
    private Set<Evidence> evidenceSet;

    @ManyToOne
    @JoinColumn(name = "LEAD_INVESTIGATOR", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name="working_detective_case",
            joinColumns=@JoinColumn(name="case_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="detective_id", referencedColumnName="id"))
    private Set<Detective> assigned = new HashSet<>();

    public CriminalCase() {
        super();
        this.status = CaseStatus.SUBMITTED;
        this.type = CaseType.UNCATEGORIZED;
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "number='" + number + '\'' +
                ", type=" + type +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", evidenceSet=" + evidenceSet +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                '}';
    }
}
