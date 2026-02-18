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
public class JobRequisitionDto {
    private Long requisitionId;
    private Long jobId;
    private Long departmentId;
    private Long openings;
    private String status;
    private Boolean isActive;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime deactivatedDate;
    private String deactivatedBy;
    private List<Long> applicationIds;
}
