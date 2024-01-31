package com.tangent.employeemanagementservice.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse<T> {

    T result;

    public static <T> ApiResponse<T> of(T data) {
        return ApiResponse.<T>builder()
                .result(data)
                .build();
    }
}
