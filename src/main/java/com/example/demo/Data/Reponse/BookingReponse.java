package com.example.demo.Data.Reponse;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class BookingReponse {
    private int id;
    private int accountId;
    private int staffId;
    private int doctorId;
    private String name;
    private Boolean gender;
    private String phone;
    private String address;
    private String descirption;
    private Date date;
    private String time;
    private int status;
    private Date createdAt;
    private Date updatedAt;
}
