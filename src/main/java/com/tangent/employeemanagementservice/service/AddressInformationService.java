package com.tangent.employeemanagementservice.service;

import com.tangent.employeemanagementservice.controller.request.AddressInformationRequest;
import com.tangent.employeemanagementservice.entity.AddressInformation;
import com.tangent.employeemanagementservice.exception.EmployeeAddressDoesNotExistException;
import com.tangent.employeemanagementservice.repository.AddressInformationRepository;
import com.tangent.employeemanagementservice.util.RandomIdentityGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressInformationService {

    private final AddressInformationRepository addressInformationRepository;

    public AddressInformation saveOrUpdate(AddressInformationRequest addressInformationRequest){

        var addressInformation = new AddressInformation();

        if (addressInformationRequest.getId() == null) {

            var id = RandomIdentityGenerator.getIdentity();
            addressInformation.setId(id);
        }
        else {
            addressInformation = this.get(addressInformationRequest.getId());
        }

        addressInformation.setStreetAddress(addressInformationRequest.getStreetAddress());
        addressInformation.setCity(addressInformationRequest.getCity());
        addressInformation.setCountry(addressInformationRequest.getCountry());
        addressInformation.setPostalCode(addressInformationRequest.getPostalCode());

        return this.addressInformationRepository.save(addressInformation);

    }

    private AddressInformation get(String id) {

        return this.addressInformationRepository.findById(id).orElseThrow(EmployeeAddressDoesNotExistException::new);
    }
}
