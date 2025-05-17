package com.spring.application.management.system.repositories;

import com.spring.application.management.system.entity.Applicant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationPagingAndSortingRepository extends PagingAndSortingRepository<Applicant, Long> {
}
