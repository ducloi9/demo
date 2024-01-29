package com.example.demo.Data.Request;

import com.example.demo.Data.Entity.Account;
import lombok.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class AccountRequest {
    private String email;
    private String password;
    private int role;
    private Date createdAt;
    private Date updatedAt;


}
