package com.tangent.employeemanagementservice.service;

import com.tangent.employeemanagementservice.controller.request.SkillRequest;
import com.tangent.employeemanagementservice.entity.Employee;
import com.tangent.employeemanagementservice.entity.Skill;
import com.tangent.employeemanagementservice.exception.SkillDoesNotExistException;
import com.tangent.employeemanagementservice.repository.SkillRepository;
import com.tangent.employeemanagementservice.util.RandomIdentityGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public Skill save(Employee employee, SkillRequest skillItem){

        var skill = new Skill();

        if (skillItem.getId() == null) {
            var id = RandomIdentityGenerator.getIdentity();
            skill.setId(id);
        }
        else {
            skill = this.get(skillItem.getId());
        }

        skill.setSkillName(skillItem.getSkillName());
        skill.setSeniorityRating(skillItem.getSeniorityRating());
        skill.setYearsOfExperience(skillItem.getYearsOfExperience());
        skill.setEmployee(employee);

        return this.skillRepository.save(skill);
    }

    private Skill get(String id) {
        return skillRepository.findById(id).orElseThrow(SkillDoesNotExistException::new);
    }

    public void deleteAll(List<Skill> skills) {

        this.skillRepository.deleteAll(skills);

    }
}
