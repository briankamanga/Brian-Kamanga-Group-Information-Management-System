package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.ApplicationDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Application;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Candidate;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.JobRequisition;
import com.briankamangagroup.briankamangagroup_information_management_system.exception.ResourceNotFoundException;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.ApplicationMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.ApplicationRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.CandidateRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.JobRequisitionRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.ApplicationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    private CandidateRepository candidateRepository;
    private JobRequisitionRepository jobRequisitionRepository;
    

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = ApplicationMapper.mapToApplicationEntity(applicationDto);

        // FKs will be set in the service layer after fetching the related entities (Candidate and JobRequisition)
        Candidate candidate = candidateRepository.findById(applicationDto.getCandidateId())
                .orElseThrow(
                    () -> new ResourceNotFoundException("Candidate with ID: " + applicationDto.getCandidateId() + " doesn't exist!")
                );

        JobRequisition jobRequisition = jobRequisitionRepository.findById(applicationDto.getJobRequisitionId())
                .orElseThrow(
                    () -> new ResourceNotFoundException("JobRequisition with ID: " + applicationDto.getJobRequisitionId() + " doesn't exist!")
                );
                
        // Set the related entities in the Application entity
        application.setCandidate(candidate);
        application.setJobRequisition(jobRequisition);


        Application savedApplication = applicationRepository.save(application);
        return ApplicationMapper.mapToApplicationDto(savedApplication);
    }

}
