package com.evidence.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity implements Serializable {

    protected Long id;

    protected int version;

    protected LocalDateTime createdAt;

    protected LocalDateTime modifiedAt;
}
