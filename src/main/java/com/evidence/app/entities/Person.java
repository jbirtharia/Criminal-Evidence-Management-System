package com.evidence.app.entities;

import com.evidence.app.contants.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author JayendraB
 * @createdOn 5/13/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "seqPersonGen", allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = Person.FIND_BY_COMPLETE_NAME, query = "from Person p where p.firstName=:fn and p.lastName=:ln"),
        @NamedQuery(name = Person.FIND_BY_LAST_NAME, query = "from Person p where p.lastName= ?1")
})
@JsonIgnoreProperties(value="password", allowSetters = true)
public class Person extends AbstractEntity{

    public static final String FIND_BY_COMPLETE_NAME = "findByCompleteName";
    public static final String FIND_BY_LAST_NAME = "findAllByLastName";

    public interface BasicValidation{}

    @NotNull(groups = BasicValidation.class)
    @Size(min = 3, max = 30, groups = BasicValidation.class)
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull(groups = BasicValidation.class)
    @Size(min = 3, max = 30, groups = BasicValidation.class)
    @Column(nullable = false)
    private String firstName;

    @NotNull(groups = BasicValidation.class)
    @Size(min = 3, max = 30, groups = BasicValidation.class)
    @Column(nullable = false)
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 4, max = 50)
    @Column(nullable = false)
    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATA_TIME_FORMAT)
    @NotNull(groups = BasicValidation.class)
    @DateTimeFormat(pattern = Constants.DATA_TIME_FORMAT)
    @Column(nullable = false)
    private LocalDateTime hiringDate;

    @JsonIgnore
    @Transient
    private String newPassword;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(hiringDate.toLocalDate(), person.hiringDate.toLocalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, hiringDate.toLocalDate());
    }

    @Override
    public String toString() {
        return String.format("Person[username='%s', firstName='%s', lastName='%s', hiringDate='%s']%n",
                username, firstName, lastName, hiringDate == null? "" : hiringDate.toString());

    }
}
