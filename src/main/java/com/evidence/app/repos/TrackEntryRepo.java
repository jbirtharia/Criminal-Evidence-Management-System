package com.evidence.app.repos;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Evidence;
import com.evidence.app.entities.TrackEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author JayendraB
 * Created on 26/05/21
 */
public interface TrackEntryRepo  extends JpaRepository<TrackEntry, Long> {

    List<TrackEntry> findByDate(LocalDateTime localDate);

    List<TrackEntry> findByEvidence(Evidence evidence);

    List<TrackEntry> findByDetective(Detective detective);
}
