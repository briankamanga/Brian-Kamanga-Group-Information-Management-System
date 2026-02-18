package com.briankamangagroup.briankamangagroup_information_management_system.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Long applicationId;
    private Long candidateId;
    private Long jobRequisitionId;
    private String stage;
    private String status;
    private Boolean isActive = true;    
    private LocalDateTime createdDate;
    private String createdBy;   
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime deactivatedDate;    
    private String deactivatedBy;
}
