package com.tangent.employeemanagementservice.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "skill")
@Data
@DynamicUpdate
public class Skill {

    @Id
    private String id;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;

    @Column(name = "seniority_rating")
    private String seniorityRating;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
