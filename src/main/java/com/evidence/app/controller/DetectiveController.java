package com.evidence.app.controller;

import com.evidence.app.contants.Constants;
import com.evidence.app.entities.Detective;
import com.evidence.app.services.DetectiveServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@RestController
@RequestMapping(Constants.APP_URL)
public class DetectiveController {

    @Autowired
    DetectiveServiceDemo detectiveServiceDemo;

    /**
     * Get detective info detective.
     *
     * @return the detective
     */
    @GetMapping(Constants.GET_DETECTIVE_URL)
    public Detective getDetectiveInfo(){
        return detectiveServiceDemo.getDetectiveData();
    }
}
