package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "application",
    schema = "human_resource"
)
public class Application {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "application_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long applicationId;

    // Foreign Key to Candidate Entity
    // private Long candidateId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "candidate_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_application_candidate_id"
        )
    )
    private Candidate candidate;

    // Foreign Key to JobRequisition Entity
    // private Long requisitionId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "requisition_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_application_requisition_id"
        )
    )
    private JobRequisition jobRequisition;


    @Nationalized
    @Column(
        name = "stage",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String stage;


    @Nationalized
    @Column(
        name = "status",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
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
