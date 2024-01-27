package com.example.demo.Service;

import com.example.demo.Data.Entity.Account;
import com.example.demo.Data.Mapper.AccountMapper;
import com.example.demo.Data.Reponse.AccountReponse;
import com.example.demo.Data.Request.AccountRequest;
import com.example.demo.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public Optional<AccountReponse> login(AccountRequest request) {
        Optional<Account> accountOptional = accountRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword());

        return accountOptional.map(accountMapper::toResponse);
    }
}
