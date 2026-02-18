package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.CandidateDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Candidate;

public class CandidateMapper {
    public static CandidateDto mapToCandidateDto(Candidate candidate) {
        if (candidate == null) {
            return null;
        }

        return new CandidateDto(
            candidate.getCandidateId(),
            candidate.getName(),
            candidate.getEmail(),
            candidate.getPhone(),
            candidate.getResumeUrl(),
            candidate.getSource(),
            candidate.getIsActive(),
            candidate.getCreatedDate(),
            candidate.getCreatedBy(),
            candidate.getModifiedDate(),
            candidate.getModifiedBy(),
            candidate.getDeactivatedDate(),
            candidate.getDeactivatedBy(),
            null // applicationIds will be set in the service layer
        );
    }

    public static Candidate mapToCandidateEntity(CandidateDto candidateDto) {
        if (candidateDto == null) {
            return null;
        }

        return new Candidate(
            candidateDto.getCandidateId(),
            candidateDto.getName(),
            candidateDto.getEmail(),
            candidateDto.getPhone(),
            candidateDto.getResumeUrl(),
            candidateDto.getSource(),
            candidateDto.getIsActive(),
            candidateDto.getCreatedDate(),
            candidateDto.getCreatedBy(),
            candidateDto.getModifiedDate(),
            candidateDto.getModifiedBy(),
            candidateDto.getDeactivatedDate(),
            candidateDto.getDeactivatedBy(),
            null // applications will be set in the service layer
        );
    }

}
