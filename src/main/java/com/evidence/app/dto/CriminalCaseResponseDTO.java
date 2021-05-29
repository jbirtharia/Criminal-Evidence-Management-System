package com.evidence.app.dto;

import com.evidence.app.entities.CaseStatus;
import com.evidence.app.entities.CaseType;
import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Evidence;
import lombok.Data;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author JayendraB
 * Created on 29/05/21
 */
@Data
public class CriminalCaseResponseDTO {

    private String number;

    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    private CaseStatus status;

    private String notes;

    private Set<Evidence> evidenceSet;

    private Detective leadInvestigator;

    private Set<Detective> assigned;

    public CriminalCaseResponseDTO(){

        this.evidenceSet = new LinkedHashSet<>();
        this.assigned = new LinkedHashSet<>();
    }

}
