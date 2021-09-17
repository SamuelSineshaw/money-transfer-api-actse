package edu.act.moneytransfer.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "first name can not be blanck")
    @Size(max = 15)
    private String firstName;

    @NotBlank(message = "middle name can not be blanck")
    @Column(nullable = false)
    @Size(max = 15)
    private String middleName;

    @NotBlank(message = "last name can not be blanck")
    @Column(nullable = false)
    @Size(max = 15)
    private String lastName;

    @NotBlank(message = "email is mandatory")
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank(message = "phone number is mandatory")
    @Column(nullable = false,unique = true)
    private String phoneNumber;

    @NotNull(message= "date of birth is mandatory")
    @Column(nullable =false)
    private LocalDate dateOfBirth;

    @NotNull(message= "pin can not be empity")
    @Column(nullable = false)
    private Integer pin;


    private Boolean isVerified= Boolean.FALSE;

    private Double balance=0.0;


}
