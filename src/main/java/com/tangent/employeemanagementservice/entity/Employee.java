package com.tangent.employeemanagementservice.entity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@DynamicUpdate
public class Employee {

    @Id
    private String id; // TODO need to change this

    @Column(name = "first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
    private AddressInformation addressInformation;

    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();

}
