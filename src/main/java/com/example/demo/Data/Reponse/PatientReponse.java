package com.example.demo.Data.Reponse;

import jakarta.persistence.Column;
import lombok.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PatientReponse {
    private Integer id;

    @Column(name = "account_id")
    private int accountId;


    private String name;

    @Column(name = "dob")
    private Date dateOfBirth;

    private Integer gender;

    private String phone;

    private String address;

    private String description;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "update_at")
    private Date updatedAt;
}
