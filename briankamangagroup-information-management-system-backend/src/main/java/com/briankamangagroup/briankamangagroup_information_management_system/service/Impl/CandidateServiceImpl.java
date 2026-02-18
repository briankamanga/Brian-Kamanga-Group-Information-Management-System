package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.CandidateDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Application;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Candidate;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.CandidateMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.CandidateRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.CandidateService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService{
    private CandidateRepository candidateRepository;

    @Override
    public CandidateDto createCandidate(CandidateDto candidateDto) {
        Candidate candidate = CandidateMapper.mapToCandidateEntity(candidateDto);

        // Set system-generated fields 
        candidate.setIsActive(true); // ⭐ REQUIRED FIX: Ensure new candidates are active by default
        candidate.setCreatedDate(LocalDateTime.now()); 
        candidate.setCreatedBy("system"); // or authenticated user

        Candidate savedCandidate = candidateRepository.save(candidate);

        List<Long> applicationIds = savedCandidate.getApplications() == null
            ? List.of()
            : savedCandidate.getApplications()
                .stream()
                .map(Application::getApplicationId)
                .toList();


        CandidateDto savedCandidateDto = CandidateMapper.mapToCandidateDto(savedCandidate);
        savedCandidateDto.setApplicationIds(applicationIds);
        return savedCandidateDto;
    }

}
