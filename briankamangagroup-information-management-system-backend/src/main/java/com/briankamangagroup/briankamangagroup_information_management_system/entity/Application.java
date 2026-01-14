package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;

public class Application {
    private Long applicationId;

    // Foreign Key to Candidate Entity
    private Long candidateId;

    // Foreign Key to JobRequisition Entity
    private Long requisitionId;
    private String stage;
    private String status;

    // CREATE TABLE Application (
    //     application_id   BIGINT PRIMARY KEY,
    //     candidate_id     BIGINT NOT NULL,
    //     requisition_id   BIGINT NOT NULL,
    //     stage            VARCHAR(100),
    //     status           VARCHAR(50),

    //     CONSTRAINT fk_application_candidate
    //         FOREIGN KEY (candidate_id) REFERENCES Candidate(candidate_id),

    //     CONSTRAINT fk_application_requisition
    //         FOREIGN KEY (requisition_id) REFERENCES JobRequisition(requisition_id)
    // );







    @Column(
        name = "is_active",
        nullable = false,
        columnDefinition = "BIT"
    )
    @ColumnDefault("1")
    private Boolean isActive = true;    

    @Column(
        name = "created_date",
        nullable = false,
        columnDefinition = "DATETIME2"
    )
    @ColumnDefault("GETDATE()")
    private LocalDateTime createdDate;

    @Nationalized
    @Column(
        name = "created_by",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    @ColumnDefault("SYSTEM_USER")
    private String createdBy;   

    @Column(
        name = "modified_date",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime modifiedDate;

    @Nationalized
    @Column(
        name = "modified_by",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String modifiedBy;

    @Column(
        name = "deactivated_date",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime deactivatedDate;    

    @Nationalized
    @Column(
        name = "deactivated_by",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String deactivatedBy;


}
