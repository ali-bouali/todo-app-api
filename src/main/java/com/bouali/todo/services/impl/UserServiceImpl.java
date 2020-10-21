package com.bouali.todo.services.impl;

import com.bouali.todo.dto.UserDto;
import com.bouali.todo.exception.EntityNotFoundException;
import com.bouali.todo.exception.ErrorCodes;
import com.bouali.todo.exception.InvalidEntityException;
import com.bouali.todo.repositories.UserRepository;
import com.bouali.todo.services.UserService;
import com.bouali.todo.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto user) {
        List<String> errors = UserValidator.validateUser(user);
        if (!errors.isEmpty()) {
            log.error("User is not valid {}", user);
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(user)));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        if (id == null) {
            log.error("User id is null");
            return null;
        }
        return userRepository.findById(id).map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("User id is null");
            throw new EntityNotFoundException("No user found with ID = " + id, ErrorCodes.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto login(UserDto user) {
        List<String> errors = UserValidator.validateUserCredentials(user.getEmail(), user.getPassword());
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("User is not valid", ErrorCodes.USER_NOT_VALID, errors);
        }
        return userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword())
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user found with Email = " + user.getEmail() + " and Password = <HIDDEN_PASSWORD>", ErrorCodes.USER_NOT_FOUND));
    }
}
