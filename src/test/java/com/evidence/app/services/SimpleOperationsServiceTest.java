package com.evidence.app.services;

import com.evidence.app.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Simple operations service test.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
public class SimpleOperationsServiceTest extends SimpleServiceTestBase {

    static final Long DETECTIVE_ID = 1L;
    static final String BADGE_NO = "NY112233";

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        init();
        // TODO : Create detective
        Person person = new Person();
        person.setId(DETECTIVE_ID);
        person.setFirstName("Sherlock");
        person.setLastName("Holmes");
        person.setHiringDate(LocalDateTime.now());
        person.setPassword("123");
        Detective detective = detectiveService.createDetective(person, Rank.INSPECTOR);
        assertNotNull(detective);
        detective.setBadgeNumber(BADGE_NO);
        assertEquals(DETECTIVE_ID, detective.getId());
        detective.setBadgeNumber(BADGE_NO);

        // TODO : Create storage entries
        Storage storage = new Storage();
        storage.setName("Here");
        storage.setLocation("Here");
        storageRepo.save(storage);
        assertNotNull(storage.getId());

        Storage storage1 = new Storage();
        storage1.setName("There");
        storage1.setLocation("There");
        storageRepo.save(storage1);
        assertNotNull(storage1.getId());
    }

    /**
     * Test create criminal case.
     */
    @DisplayName("Create Investigation Test")
    @Test
    public void testCreateCriminalCase(){
        // TODO : Create evidence map
        Map<Evidence, String> evidenceLocationMap = new HashMap<>();
        Evidence ev = new Evidence();
        ev.setItemName("drugs");
        ev.setNotes("confiscated from minor");
        ev.setNumber("DR12345687");

        evidenceLocationMap.put(ev, "Here");

        // TODO : Create criminal case
        CriminalCase criminalCase = operationsService.createCriminalCase(CaseType.FELONY,
                "Drugs being sold to minors", BADGE_NO, evidenceLocationMap);

        assertNotNull(criminalCase);
        assertNotNull(criminalCase.getLeadInvestigator());
    }


}
