package com.tangent.employeemanagementservice.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    @Pattern(regexp = "^(?!\\s*$).+", message = "first name is required")
    private String firstName;

    @JsonProperty("last_name")
    @Pattern(regexp = "^(?!\\s*$).+", message = "last name is required")
    private String lastName;

    @JsonProperty("contact_number")
    @Pattern(regexp = "^(?!\\s*$).+", message = "contact number is required")
    private String contactNumber;

    @JsonProperty("email_address")
    @Pattern(regexp = "^(?!\\s*$).+", message = "email address is required")
    private String emailAddress;

    @JsonProperty("date_of_birth")
    @Pattern(regexp = "^(?!\\s*$).+", message = "date of birth is required")
    private String dateOfBirth;

    @JsonProperty("address_information")
    private AddressInformationRequest addressInformation;

    @JsonProperty("skills")
    private List<SkillRequest> skills;

}
