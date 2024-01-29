package com.example.demo.Data.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_id")
    private int accountId;

    private String name;
    private Date dob;
    private Boolean gender;
    private String phone;
    private String address;
    private String description;
}

