package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.JobRequisitionDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.JobRequisitionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/jobrequisitions")
public class JobRequisitionController {
    private JobRequisitionService jobRequisitionService;

    @PostMapping
    public ResponseEntity<JobRequisitionDto> createJobRequisition(@RequestBody JobRequisitionDto jobRequisitionDto) {
        JobRequisitionDto createdJobRequisition = jobRequisitionService.createJobRequisition(jobRequisitionDto);
        return new ResponseEntity<>(createdJobRequisition, HttpStatus.CREATED);
    }

}
