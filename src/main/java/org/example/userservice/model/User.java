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
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Email is required")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Age is required")
    private Integer age;

    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dob;

    public String getEmail() {
        return  email;
    }

}
