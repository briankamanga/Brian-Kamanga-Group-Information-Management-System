package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.briankamangagroup.briankamangagroup_information_management_system.dto.JobRequisitionDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Application;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.JobRequisition;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.JobRequisitionMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.JobRequisitionRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.JobRequisitionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JobRequisitionServiceImpl implements JobRequisitionService{
    private JobRequisitionRepository jobRequisitionRepository;
    
    @Override
    public JobRequisitionDto createJobRequisition(JobRequisitionDto jobRequisitionDto) {
        JobRequisition jobRequisition = JobRequisitionMapper.mapToJobRequisitionEntity(jobRequisitionDto);
        JobRequisition savedJobRequisition = jobRequisitionRepository.save(jobRequisition);

        List<Long> applicationIds = savedJobRequisition.getApplications() == null
            ? List.of()
            : savedJobRequisition.getApplications()
                .stream()
                .map(Application::getApplicationId)
                .toList();

        JobRequisitionDto savedJobRequisitionDto = JobRequisitionMapper.mapJobRequisitionDto(savedJobRequisition);
        savedJobRequisitionDto.setApplicationIds(applicationIds);
        return savedJobRequisitionDto;
    }

}
