package com.evidence.app.entities;

import com.evidence.app.contants.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seqTrackEntryGen", allocationSize = 1)
@Entity
public class TrackEntry extends AbstractEntity{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATA_TIME_FORMAT)
    @NotNull
    @Column(name= "track_date", nullable = false)
    @DateTimeFormat(pattern = Constants.DATA_TIME_FORMAT)
    protected LocalDateTime date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "evidence_fk", nullable = false)
    private Evidence evidence;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "detective_fk", nullable = false)
    private Detective detective;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TrackAction action;

    @NotEmpty
    @Column
    private String reason;


}
