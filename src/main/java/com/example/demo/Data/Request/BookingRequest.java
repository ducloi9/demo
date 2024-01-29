package com.example.demo.Data.Request;
import lombok.*;

import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class BookingRequest {
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
}
