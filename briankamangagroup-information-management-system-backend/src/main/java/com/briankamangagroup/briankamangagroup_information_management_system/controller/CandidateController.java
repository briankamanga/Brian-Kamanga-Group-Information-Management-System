package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.CandidateDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.CandidateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CandidateDto> createCandidate(@RequestBody CandidateDto candidateDto) {
        CandidateDto createdCandidate = candidateService.createCandidate(candidateDto);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }
}
