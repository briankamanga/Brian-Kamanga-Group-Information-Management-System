package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.JobRequisitionDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.JobRequisition;

public class JobRequisitionMapper {
    public static JobRequisition mapToJobRequisitionEntity(JobRequisitionDto jobRequisitionDto) {
        if (jobRequisitionDto == null) {
            return null;
        }

        return new JobRequisition(
            jobRequisitionDto.getRequisitionId(),
            null, // jobId will be set in the service layer after fetching the JobPosition entity
            null, // departmentId will be set in the service layer after fetching the JobApplication entities
            jobRequisitionDto.getOpenings(),
            jobRequisitionDto.getStatus(),
            jobRequisitionDto.getIsActive(),
            jobRequisitionDto.getCreatedDate(),
            jobRequisitionDto.getCreatedBy(),
            jobRequisitionDto.getModifiedDate(),
            jobRequisitionDto.getModifiedBy(),
            jobRequisitionDto.getDeactivatedDate(),
            jobRequisitionDto.getDeactivatedBy(),
                null // applications will be set in the service layer after fetching the JobApplication entities
        );
    }

    public static JobRequisitionDto mapJobRequisitionDto(JobRequisition jobRequisition) {
        if (jobRequisition == null) {
            return null;
        }

        return new JobRequisitionDto(
            jobRequisition.getRequisitionId(),
            null, // jobId will be set in the service layer after fetching the JobPosition entity
            null, // departmentId will be set in the service layer after fetching the JobApplication entities
            jobRequisition.getOpenings(),
            jobRequisition.getStatus(),
            jobRequisition.getIsActive(),
            jobRequisition.getCreatedDate(),
            jobRequisition.getCreatedBy(),
            jobRequisition.getModifiedDate(),
            jobRequisition.getModifiedBy(),
            jobRequisition.getDeactivatedDate(),
            jobRequisition.getDeactivatedBy(),
            null // applicationIds will be set in the service layer after fetching the JobApplication entities
        );
    }
}
