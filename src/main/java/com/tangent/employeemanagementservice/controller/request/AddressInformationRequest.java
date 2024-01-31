package com.tangent.employeemanagementservice.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressInformationRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("street_address")
    @Pattern(regexp = "^(?!\\s*$).+", message = "street address is required")
    private String streetAddress;

    @JsonProperty("city")
    @Pattern(regexp = "^(?!\\s*$).+", message = "city is required")
    private String city;

    @JsonProperty("postal_code")
    @Pattern(regexp = "^(?!\\s*$).+", message = "postal code is required")
    private String postalCode;

    @JsonProperty("country")
    @Pattern(regexp = "^(?!\\s*$).+", message = "country is required")
    private String country;
}
