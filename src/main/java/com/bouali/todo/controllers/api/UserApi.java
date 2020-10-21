package com.bouali.todo.controllers.api;

import com.bouali.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bouali.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {

    @PostMapping(value = APP_ROOT + "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create user", notes = "Creates a new user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<UserDto> createUser(
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

    @PatchMapping(value = APP_ROOT + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update user", notes = "Updates an existing user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<UserDto> updateUser(
            @ApiParam(value = "User ID", required = true) Long id,
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns the list of the users", responseContainer = "List<UserDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the users"),
    })
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping(value = APP_ROOT + "/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns the list of the users", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    ResponseEntity<UserDto> getUser(
            @ApiParam(value = "The use id", required = true) Long id
    );

    @DeleteMapping(value = APP_ROOT + "/users/delete/{id:.+}")
    @ApiOperation(value = "Delete a user", notes = "Deletes a user by ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    ResponseEntity deleteUser(
            @ApiParam(value = "The use id", required = true) Long id
    );
}
