package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    name = "job_requisition",
    schema = "human_resource"
)
public class JobRequisition {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "job_requisition_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long requisitionId;

    // Foreign Key to JobPosition Entity
    // private Long jobId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "job_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_job_requisition_job_position_id"
        )
    )
    private JobPosition jobPosition;


    // Foreign Key to Department Entity
    // private Long departmentId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "department_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_job_requisition_department_id"
        )
    )
    private Department department;

    @Nationalized
    @Column(
        name = "openings",
        nullable = true,
        columnDefinition = "INT"
    )
    private Long openings;

    @Nationalized
    @Column(
        name = "status",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String status;

    // CREATE TABLE JobRequisition (
    //     requisition_id   BIGINT PRIMARY KEY,
    //     job_id           BIGINT NOT NULL,
    //     department_id    BIGINT NOT NULL,
    //     openings         INT NOT NULL,
    //     status           VARCHAR(50),

    //     CONSTRAINT fk_requisition_job
    //         FOREIGN KEY (job_id) REFERENCES Job(job_id),

    //     CONSTRAINT fk_requisition_department
    //         FOREIGN KEY (department_id) REFERENCES Department(department_id)
    // );





    @Column(
        name = "is_active",
        nullable = false,
        columnDefinition = "BIT"
    )
    @ColumnDefault("1")
    private Boolean isActive;

    @Column(
        name = "created_date",
        nullable = false,
        columnDefinition = "DATETIME2"
    )
    @ColumnDefault("GETDATE()")
    private LocalDateTime createdDate;

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

    @Column(
        name = "deactivated_by",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String deactivatedBy;




    // OneToMany with Application
    @OneToMany(
        mappedBy = "jobRequisition",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Application> applications;





}
