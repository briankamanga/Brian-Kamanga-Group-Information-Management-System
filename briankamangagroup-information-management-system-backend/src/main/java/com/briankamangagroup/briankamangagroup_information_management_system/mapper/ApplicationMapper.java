package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.ApplicationDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Application;

public class ApplicationMapper {
    public static ApplicationDto mapToApplicationDto(Application application) {
        if (application == null) {
            return null;
        }

        return new ApplicationDto(
            application.getApplicationId(),
            null, // Candidate will be set in the service layer
            // application.getCandidate() != null ? application.getCandidate
            // if (application.getCandidate() != null) {
            //     return application.getCandidate().getCandidateId();
            // } else {
            //     return null;
            // },
            null, // JobRequisition will be set in the service layer
            // application.getJobRequisition() != null ? application.getJobRequisition().getRequisitionId() : null,
            application.getStage(),
            application.getStatus(),
            application.getIsActive(),
            application.getCreatedDate(),
            application.getCreatedBy(),
            application.getModifiedDate(),
            application.getModifiedBy(),
            application.getDeactivatedDate(),
            application.getDeactivatedBy()
        );
        // ApplicationDto applicationDto = new ApplicationDto();
        // applicationDto.setApplicationId(application.getApplicationId());
        // applicationDto.setCandidateId(application.getCandidate() != null ? application.getCandidate().getCandidateId() : null);
        // // Set other fields as needed

        // return applicationDto;
    }

    public static Application mapToApplicationEntity(ApplicationDto applicationDto) {
        if (applicationDto == null) {
            return null;
        }

        return new Application(
            applicationDto.getApplicationId(),
            null, // Candidate will be set in the service layer
            null, // JobRequisition will be set in the service layer
            applicationDto.getStage(),
            applicationDto.getStatus(),
            applicationDto.getIsActive(),
            applicationDto.getCreatedDate(),
            applicationDto.getCreatedBy(),
            applicationDto.getModifiedDate(),
            applicationDto.getModifiedBy(),
            applicationDto.getDeactivatedDate(),
            applicationDto.getDeactivatedBy()
        );
    }

}
