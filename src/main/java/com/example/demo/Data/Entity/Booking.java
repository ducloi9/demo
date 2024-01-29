package com.example.demo.Data.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account_id")
    private int accountId;
    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "doctor_id")
    private int doctorId;

    private String name;
    private Boolean gender;
    private String phone;
    private String address;
    private String descirption;
    private Date date;
    private String time;
    private int status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}