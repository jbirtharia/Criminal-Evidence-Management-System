package com.evidence.app.services.impl;

import com.evidence.app.contants.Constants;
import com.evidence.app.dto.CaseDTO;
import com.evidence.app.dto.CriminalCaseResponseDTO;
import com.evidence.app.entities.*;
import com.evidence.app.services.DetectiveService;
import com.evidence.app.services.OperationsService;
import com.evidence.app.services.StorageService;
import com.evidence.app.util.ConvertUtils;
import com.evidence.app.util.DateProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Detective service.
 *
 * @author JayendraB
 * @createdOn 5 /13/2021
 */
@Service
@Slf4j
public class DetectiveServiceDemo {

    @Autowired
    private OperationsService operationsService;

    @Autowired
    private DetectiveService detectiveService;

    @Autowired
    private StorageService storageService;

    /**
     * Creating case criminal case.
     *
     * @param caseDTO the case dto
     * @return the criminal case
     */
    public CriminalCaseResponseDTO creatingCase(CaseDTO caseDTO){

        Person person = new Person(caseDTO.getUsername(),caseDTO.getFirstName(),caseDTO.getLastName(),
                caseDTO.getPassword(), DateProcessor.toDate(DateProcessor.getCurrentDateAndTime()),"");

        Detective detective = detectiveService.createDetective(person,Rank.CHIEF_INSPECTOR);

        // Creating Storage for Criminal Case
        Storage storage = storageService.createStorage(Constants.STORAGE_NAME,Constants.STORAGE_NAME);

        // Storing Evidence with Criminal Case
        Map<Evidence, String> evidenceLocationMap = new HashMap<>();
        Evidence ev = new Evidence();
        ev.setItemName("drugs");
        ev.setNotes("confiscated from minor");
        ev.setNumber("DR12345687");

        evidenceLocationMap.put(ev, storage.getName());

        // Creating criminal case
        CriminalCase criminalCase = operationsService.createCriminalCase(CaseType.FELONY,
                "Drugs being sold to minors", detective.getBadgeNumber(), evidenceLocationMap);
        // criminalCase.getLeadInvestigator().setCriminalCases(Set.of(criminalCase));

        log.info("Criminal Case Data : {}",criminalCase);
        return ConvertUtils.cloneObjectToCriminalCaseResponseDTO(criminalCase);
    }
}
