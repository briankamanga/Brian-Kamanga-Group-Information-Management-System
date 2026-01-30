package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    name = "job_position",
    schema = "human_resource"
)
public class JobPosition {
    @Id
    @Column(
        name = "job_id", 
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long jobId;

    @Nationalized
    @Column(
        name = "job_title",
        nullable = false,
        columnDefinition = "NVARCHAR(200)"
    )
    private String title;
    
    @Nationalized
    @Column(
        name = "job_family",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String jobFamily;

    @Nationalized
    @Column(
        name = "job_level",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String jobLevel;

    @Nationalized
    @Column(
        name = "description",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String description;

    @Nationalized
    @Column(
        name = "competencies",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String competencies; // JSON string representing competencies


//     CREATE TABLE Job (
//     job_id        BIGINT PRIMARY KEY,
//     title         VARCHAR(200) NOT NULL,
//     job_family    VARCHAR(100),
//     job_level     VARCHAR(50),
//     description   TEXT,
//     competencies  JSON
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



    // OneToMany with Employee
    @OneToMany(
        mappedBy = "jobPosition",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees;



    // OneToMany with JobRequisition
    @OneToMany(
        mappedBy = "jobPosition",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<JobRequisition> jobRequisitions;

}
