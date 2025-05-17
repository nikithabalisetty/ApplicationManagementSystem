package com.spring.application.management.system.service;

import com.spring.application.management.system.entity.Applicant;
import com.spring.application.management.system.repositories.ApplicantCrudRepository;
import com.spring.application.management.system.repositories.ApplicantJpaRepository;
import com.spring.application.management.system.repositories.ApplicationPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;

    @Autowired
    private ApplicationPagingAndSortingRepository applicationPagingAndSortingRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Applicant> getAllApplicants(){
        return applicantCrudRepository.findAll();
        // Using CrudRepository
//        Iterable<Applicant> all =  applicantCrudRepository.findAll();
//        List<Applicant> applicantList = new ArrayList<>();
//        all.forEach(applicantList::addFirst);
//        return applicantList;
    }

    public Applicant saveApplicantCrud(Applicant applicant){
        return applicantCrudRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size){
        return applicationPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }

    public List<Applicant> getApplicantByStatus(String status){
        return applicantJpaRepository.findByStatus(status);
    }

    public List<Applicant> getApplicantByPartialName(String name){
        return applicantJpaRepository.getApplicantByPartialName(name);
    }
}
