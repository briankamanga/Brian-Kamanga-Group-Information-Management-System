package com.briankamangagroup.briankamangagroup_information_management_system.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
    private Long candidateId;
    private String name;
    private String email;
    private String phone;
    private String resumeUrl;
    private String source;
    private Boolean isActive = true;    
    private LocalDateTime createdDate;
    private String createdBy;   
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime deactivatedDate;  
    private String deactivatedBy;
    private List<Long> applicationIds;
}
