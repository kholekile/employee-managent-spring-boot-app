package com.tangent.employeemanagementservice.repository;

import com.tangent.employeemanagementservice.entity.AddressInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressInformationRepository extends JpaRepository<AddressInformation, String> {
}
