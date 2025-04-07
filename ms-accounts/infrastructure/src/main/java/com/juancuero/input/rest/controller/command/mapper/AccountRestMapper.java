package com.juancuero.input.rest.controller.command.mapper;

import com.juancuero.command.create.CreateAccountCommand;
import com.juancuero.input.rest.controller.command.request.CreateAccountRequest;
import com.juancuero.input.rest.controller.command.response.AccountResponse;
import com.juancuero.model.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountRestMapper {

    CreateAccountCommand toCreateAccountCommand(CreateAccountRequest request);

    AccountResponse toResponse(Account account);
}
