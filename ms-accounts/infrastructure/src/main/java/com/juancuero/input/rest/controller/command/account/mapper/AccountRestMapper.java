package com.juancuero.input.rest.controller.command.account.mapper;

import com.juancuero.command.create.account.CreateAccountCommand;
import com.juancuero.input.rest.controller.command.account.request.CreateAccountRequest;
import com.juancuero.input.rest.controller.command.account.response.AccountResponse;
import com.juancuero.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountRestMapper {

    CreateAccountCommand toCreateAccountCommand(CreateAccountRequest request);

    AccountResponse toResponse(Account account);
}
