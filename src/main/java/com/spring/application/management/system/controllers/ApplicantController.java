package com.spring.application.management.system.controllers;

import com.spring.application.management.system.entity.Applicant;
import com.spring.application.management.system.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants(){
        return applicantService.getAllApplicants();
    }

    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant){
        System.out.println("Request reached controller");
        return applicantService.saveApplicantCrud(applicant);
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPagination(
            @RequestParam int page,
            @RequestParam int size){
        return applicantService.getApplicantsWithPagination(page, size);
    }

    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status){
        return applicantService.getApplicantByStatus(status);
    }

    @GetMapping("/getByPartialName")
    public List<Applicant> getApplicantByPartialName(@RequestParam String name){
        return applicantService.getApplicantByPartialName(name);
    }
}
