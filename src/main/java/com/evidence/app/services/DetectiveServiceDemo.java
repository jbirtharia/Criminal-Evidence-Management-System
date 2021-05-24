package com.evidence.app.services;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Person;
import com.evidence.app.entities.Rank;
import com.evidence.app.util.DateProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The type Detective service.
 *
 * @author JayendraB
 * @createdOn 5 /13/2021
 */
@Service
@Slf4j
public class DetectiveServiceDemo {

    /**
     * Get detective data detective.
     *
     * @return the detective
     */
    public Detective getDetectiveData(){
        Person person = new Person("jbirtharia","Jayendra","Birtharia",
                "jaybir@1994", DateProcessor.toDate(DateProcessor.getCurrentDateAndTime()),"");
        Detective detective = new Detective(person,"1012", Rank.CHIEF_INSPECTOR,Boolean.FALSE);
        log.info("Detective data : {}",detective);
        return detective;
    }
}
