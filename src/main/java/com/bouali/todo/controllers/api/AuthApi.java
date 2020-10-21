package com.bouali.todo.controllers.api;

import com.bouali.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.bouali.todo.utils.Constants.APP_ROOT;

@Api("authApi")
public interface AuthApi {

    @ApiOperation(value = "Login user", notes = "Creates a new user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The connected user.")
    })
    @PostMapping(value = APP_ROOT + "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDto> loginUser(
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user
    );
}
