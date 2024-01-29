package com.example.demo.Data.Reponse;

import jakarta.persistence.Column;
import lombok.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class DoctorReponse {
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
