package com.evidence.app.entities;

import com.evidence.app.contants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;

    @Version
    @JsonIgnore
    protected int version;

    @Column(name = "created_at", nullable = false)
    @DateTimeFormat(pattern = Constants.DATA_TIME_FORMAT)
    @JsonIgnore
    protected LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    @DateTimeFormat(pattern = Constants.DATA_TIME_FORMAT)
    @JsonIgnore
    protected LocalDateTime modifiedAt;

    /**
     * This constructor is required by JPA. All subclasses of this class will inherit this constructor.
     */
    public AbstractEntity() {
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }
}
