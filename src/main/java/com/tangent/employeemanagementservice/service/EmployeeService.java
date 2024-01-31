package com.tangent.employeemanagementservice.service;

import com.tangent.employeemanagementservice.controller.request.EmployeeRequest;
import com.tangent.employeemanagementservice.controller.request.SkillRequest;
import com.tangent.employeemanagementservice.entity.Employee;
import com.tangent.employeemanagementservice.entity.Skill;
import com.tangent.employeemanagementservice.exception.EmployeeAddressDoesNotExistException;
import com.tangent.employeemanagementservice.repository.EmployeeRepository;
import com.tangent.employeemanagementservice.util.RandomIdentityGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AddressInformationService addressInformationService;

    private final SkillService skillService;

    public Employee create(EmployeeRequest employeeRequest) {

        var employee = this.saveOrUpdate(employeeRequest);

        var addressInformation = this.addressInformationService.saveOrUpdate(employeeRequest.getAddressInformation());

        employee.setAddressInformation(addressInformation);

        this.employeeRepository.saveAndFlush(employee);

        this.populateSkills(employee, employeeRequest.getSkills());

        return this.get(employee.getId());
    }

    public Page<Employee> getAll(Pageable pageable) {

        return this.employeeRepository.findAll(pageable);
    }

    public Employee get(String id) {

        return this.employeeRepository.findById(id).orElseThrow(EmployeeAddressDoesNotExistException::new);
    }

    public void delete(String id) {

        var employee = this.get(id);

        if (employee != null) {
            this.employeeRepository.delete(employee);
        }
    }

    public Employee update(EmployeeRequest employeeRequest) {

        var employee = this.saveOrUpdate(employeeRequest);

        this.addressInformationService.saveOrUpdate(employeeRequest.getAddressInformation());

        this.populateSkills(employee, employeeRequest.getSkills());

        return this.get(employee.getId());
    }

    private Employee saveOrUpdate(EmployeeRequest employeeRequest){

        var employee = new Employee();

        if (employeeRequest.getId() == null) {

            var id = RandomIdentityGenerator.getIdentity();
            employee.setId(id);

        } else {

            employee = this.get(employeeRequest.getId());
        }

        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setContactNumber(employeeRequest.getContactNumber());
        employee.setEmailAddress(employeeRequest.getEmailAddress());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());

        return this.employeeRepository.saveAndFlush(employee);
    }

    private void populateSkills(Employee employee, List<SkillRequest> skillsRequest){

        if (skillsRequest.size() > 0) {

            List<Skill> skills = new ArrayList<>();

            if (employee.getSkills().size() > 0) {

                this.skillService.deleteAll(employee.getSkills());

                employee.setSkills(skills);

                this.employeeRepository.saveAndFlush(employee);
            }

            for (var skill : skillsRequest) {

                var savedSkill = this.skillService.save(employee, skill);

                skills.add(savedSkill);
            }

            employee.setSkills(skills);

            this.employeeRepository.saveAndFlush(employee);

        }
    }
}
