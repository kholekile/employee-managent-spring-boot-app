package com.tangent.employeemanagementservice.controller;

import com.tangent.employeemanagementservice.controller.request.EmployeeRequest;
import com.tangent.employeemanagementservice.controller.response.ApiResponse;
import com.tangent.employeemanagementservice.controller.response.EmployeeResponse;
import com.tangent.employeemanagementservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final ModelMapper modelMapper;

    @GetMapping
    @Operation(description = "Get All Employees")
    ResponseEntity<ApiResponse<Page<EmployeeResponse>>> getAll(Pageable pageable){

        var pageOfEmployees =  this.employeeService.getAll(pageable);

        Page<EmployeeResponse> response = pageOfEmployees.map(employee -> modelMapper.map(employee, EmployeeResponse.class));

        return ResponseEntity.ok(ApiResponse.of(response));
    }

    @PostMapping
    @Operation(description = "Add")
    ResponseEntity<ApiResponse<EmployeeResponse>> add(@Validated @RequestBody EmployeeRequest employeeRequest){

        var employee = this.employeeService.create(employeeRequest);

        var result = modelMapper.map(employee, EmployeeResponse.class);

        return ResponseEntity.ok().body(ApiResponse.of(result));
    }

    @GetMapping("/{id}")
    @Operation(description = "Get By Id")
    ResponseEntity<ApiResponse<EmployeeResponse>> get(@PathVariable("id") String id){

        var employee = this.employeeService.get(id);

        var result = modelMapper.map(employee, EmployeeResponse.class);

        return ResponseEntity.ok().body(ApiResponse.of(result));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete By Id")
    ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") String id){

        this.employeeService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    @Operation(description = "Update")
    ResponseEntity<ApiResponse<EmployeeResponse>> update(@PathVariable("id") String id, @Valid @RequestBody EmployeeRequest employeeRequest){

        employeeRequest.setId(id);

        var employee = this.employeeService.update(employeeRequest);

        var result = modelMapper.map(employee, EmployeeResponse.class);

        return ResponseEntity.ok().body(ApiResponse.of(result));
    }
}