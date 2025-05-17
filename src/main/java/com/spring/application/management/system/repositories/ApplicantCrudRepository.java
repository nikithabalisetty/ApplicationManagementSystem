package com.spring.application.management.system.repositories;

import com.spring.application.management.system.entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ApplicantCrudRepository extends ListCrudRepository<Applicant, Long> {
}
