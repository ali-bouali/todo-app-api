package com.bouali.todo.handlers;

import com.bouali.todo.exception.ErrorCodes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Holds error code, error message and related error messages of an error")
public class ErrorDto {

    @ApiModelProperty(value = "The error code.", required = true)
    private Integer httpCode;

    @ApiModelProperty(value = "The error code.", required = true)
    private ErrorCodes code;

    @ApiModelProperty(value = "A detailed error message.")
    private String message;

    @ApiModelProperty(value = "The input fields related to the error, if any.")
    List<String> errors = new ArrayList<>();


}
