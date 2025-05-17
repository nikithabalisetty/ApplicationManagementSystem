package com.spring.application.management.system.repositories;

import com.spring.application.management.system.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByStatus(String status);

    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> getApplicantByPartialName(@Param("name") String name);
}
