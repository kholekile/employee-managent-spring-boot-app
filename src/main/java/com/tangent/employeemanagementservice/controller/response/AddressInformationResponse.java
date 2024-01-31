package com.tangent.employeemanagementservice.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class AddressInformationResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("street_address")
    private String streetAddress;

    @JsonProperty("city")
    private String city;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("country")
    private String country;
}
