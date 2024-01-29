package com.example.demo.Data.Reponse;

import lombok.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class AccountReponse {
    private int  id;
    private String email;
    private String password;
    private int role;
    private Date createdAt;
    private Date updatedAt;
}
