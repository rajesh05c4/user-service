package org.example.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_sequence", allocationSize = 1, initialValue = 11111)
    private Long accountNumber;

    @NotNull
    private Long userId; // Foreign key reference to User (not unique)

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType; // CHECKING / SAVINGS

    @NotNull
    private String addressLine1;

    private String addressLine2;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull(message = "ZIP code is required")
    @Pattern(regexp = "\\d{5}", message = "ZIP code must be exactly 5 digits")
    private String zipCode;

    @NotNull
    @Column(precision = 12, scale = 2)
    private BigDecimal balance = BigDecimal.valueOf(0.00);

    @NotNull
    private Boolean active = true;

    @NotNull
    private LocalDate startDate = LocalDate.now();

    public enum AccountType {
        CHECKING,
        SAVINGS
    }
}
