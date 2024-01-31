package com.tangent.employeemanagementservice.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tangent.employeemanagementservice.controller.request.AddressInformationRequest;
import com.tangent.employeemanagementservice.controller.request.SkillRequest;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EmployeeResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("contact_number")
    private String contactNumber;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("address_information")
    private AddressInformationResponse addressInformation;

    @JsonProperty("skills")
    private List<SkillResponse> skills;

}
