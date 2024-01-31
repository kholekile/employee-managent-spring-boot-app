package com.tangent.employeemanagementservice.controller.response;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class ValidationFailureResponse {

    private List<HashMap<String, String>> errors;

    public ValidationFailureResponse(List<HashMap<String, String>> errors) {
        this.errors = errors;
    }

}
