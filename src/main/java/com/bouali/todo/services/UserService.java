package com.bouali.todo.services;

import com.bouali.todo.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void delete(Long id);

    UserDto login(UserDto user);
}
