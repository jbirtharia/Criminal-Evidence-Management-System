package com.evidence.app.entities;

import com.evidence.app.contants.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackEntry extends AbstractEntity{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATA_TIME_FORMAT)
    @DateTimeFormat(pattern = Constants.DATA_TIME_FORMAT)
    protected LocalDateTime date;

    private Evidence evidence;

    private Detective detective;

    private TrackAction action;

    private String reason;

}
