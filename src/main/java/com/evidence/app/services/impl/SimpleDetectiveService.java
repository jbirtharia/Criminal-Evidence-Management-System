package com.evidence.app.services.impl;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Person;
import com.evidence.app.entities.Rank;
import com.evidence.app.repos.DetectiveRepo;
import com.evidence.app.services.DetectiveService;
import com.evidence.app.util.NumberGenerator;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Simple detective service.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
@Service
@NoArgsConstructor
public class SimpleDetectiveService extends SimpleAbstractService<Detective> implements DetectiveService {

    @Autowired
    private DetectiveRepo repo;

    @Override
    public Detective createDetective(Person person, Rank rank) {
        Detective detective = new Detective();
        detective.setPerson(person);
        detective.setRank(rank);
        detective.setBadgeNumber(NumberGenerator.getBadgeNumber());
        repo.save(detective);
        return detective;
    }

    @Override
    public Detective getDetectiveForCase(String badgeNumber) {
        return repo.findByBadgeNumber(badgeNumber).orElse(null);
    }

    /**
     * Instantiates a new Simple detective service.
     *
     * @param repo the repo
     */
    public SimpleDetectiveService (DetectiveRepo repo){
        this.repo = repo;
    }
}
