package org.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1111, allocationSize = 1)
    private Long id;

    @NotNull(message = "FirstName is required")
    private String firstName;

    @NotNull(message = "LastName is required")
    private String lastName;

    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dob;

}
