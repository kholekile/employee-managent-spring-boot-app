package com.tangent.employeemanagementservice.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class SkillRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("skill_name")
    @Pattern(regexp = "^(?!\\s*$).+", message = "skill name is required")
    private String skillName;

    @JsonProperty("years_of_experience")
    @Pattern(regexp = "^(?!\\s*$).+", message = "years of experience is required")
    private String yearsOfExperience;

    @JsonProperty("seniority_rating")
    @Pattern(regexp = "^(?!\\s*$).+", message = "seniority rating is required")
    private String seniorityRating;
}
