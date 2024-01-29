package com.example.demo.Controller;

import com.example.demo.Data.Entity.Account;
import com.example.demo.Data.Reponse.AccountReponse;
import com.example.demo.Data.Request.AccountRequest;
import com.example.demo.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class LoginController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public AccountReponse login(@RequestBody AccountRequest accountRequest) {
        return accountService.login(accountRequest).orElse(null);
    }
    @PostMapping("/register")
    public ResponseEntity<AccountReponse> register(@RequestBody AccountRequest accountRequest) {
        Optional<AccountReponse> response = accountService.register(accountRequest);
        if (response.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}


