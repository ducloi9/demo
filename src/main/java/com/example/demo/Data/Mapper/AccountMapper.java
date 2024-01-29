package com.example.demo.Data.Mapper;
import com.example.demo.Data.Entity.Account;
import com.example.demo.Data.Reponse.AccountReponse;
import com.example.demo.Data.Request.AccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountRequest request);

   AccountReponse toResponse(Account entity);
}
