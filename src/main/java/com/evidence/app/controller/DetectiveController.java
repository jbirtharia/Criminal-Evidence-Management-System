package com.evidence.app.controller;

import com.evidence.app.contants.Constants;
import com.evidence.app.dto.CaseDTO;
import com.evidence.app.dto.CriminalCaseResponseDTO;
import com.evidence.app.services.impl.DetectiveServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Detective controller.
 */
@RestController
@RequestMapping(Constants.APP_URL)
public class DetectiveController {

    @Autowired
    DetectiveServiceDemo detectiveServiceDemo;

    /**
     * Creating criminal case with the help of caseDTO
     *
     * @param caseDTO the case dto
     * @return the criminal case response dto
     */
    @PostMapping(Constants.CREATE_CASE)
    public CriminalCaseResponseDTO createCase(@RequestBody CaseDTO caseDTO){
        return detectiveServiceDemo.creatingCase(caseDTO);
    }
}
