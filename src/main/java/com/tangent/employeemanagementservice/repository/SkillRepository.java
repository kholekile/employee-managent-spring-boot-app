package com.tangent.employeemanagementservice.repository;

import com.tangent.employeemanagementservice.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {

    @Modifying
    @Query("delete from Skill s where s.id = :id")
    void deleteById(String id);
}
