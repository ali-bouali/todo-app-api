package com.bouali.todo.controllers.api;

import com.bouali.todo.dto.CategoryDto;
import com.bouali.todo.dto.TodoDto;
import com.bouali.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static com.bouali.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create category", notes = "Creates a new category ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created Category.")
    })
    ResponseEntity<CategoryDto> createCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

    @PatchMapping(value = APP_ROOT + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Category", notes = "Updates an existing Category ", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<CategoryDto> updateCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto user);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns the list of the categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @GetMapping(value = APP_ROOT + "/categories/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details by category ID", notes = "Returns the list of the Todo of a selected category", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @ApiParam(value = "Category ID", required = true) Long id
    );

    @GetMapping(value = APP_ROOT + "/categories/todos/today/{userId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List of all categories and Todo for today", notes = "Returns the list of the Todo of a selected category", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @ApiParam(value = "User ID", required = true) @PathParam("userId") Long userId
    );

    @GetMapping(value = APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details by user ID", notes = "Returns the list of the categories of a selected user", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @ApiParam(value = "User ID", required = true) Long id
    );

    @GetMapping(value = APP_ROOT + "/categories/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns the list of the users", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Category"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    ResponseEntity<CategoryDto> getCategory(
            @ApiParam(value = "The category id", required = true) @PathParam(value = "id") Long id
    );

    @DeleteMapping(value = APP_ROOT + APP_ROOT + "/categories/delete/{id:.+}")
    @ApiOperation(value = "Delete category", notes = "Deletes a category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category deleted"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    ResponseEntity deleteCategory(
            @ApiParam(value = "The category id", required = true) Long id
    );
}
