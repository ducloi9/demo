package com.example.demo.Data.Request;
import jakarta.persistence.Column;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class PatientRequest {
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
