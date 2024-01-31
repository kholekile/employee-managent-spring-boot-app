package com.tangent.employeemanagementservice.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;


@Data
public class SkillResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("skill_name")
    private String skillName;

    @JsonProperty("years_of_experience")
    private String yearsOfExperience;

    @JsonProperty("seniority_rating")
    private String seniorityRating;
}
