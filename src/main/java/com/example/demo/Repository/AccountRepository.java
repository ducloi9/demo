package com.example.demo.Repository;

import com.example.demo.Data.Entity.Account;
import com.example.demo.Data.Reponse.AccountReponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface AccountRepository extends JpaRepository <Account, Integer> {

    Optional<Account> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
