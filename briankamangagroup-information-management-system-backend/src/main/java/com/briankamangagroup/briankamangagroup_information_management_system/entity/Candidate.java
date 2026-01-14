package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    name = "candidate",
    schema = "human_resource"
)
public class Candidate {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "candidate_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT",
        unique = true
    )
    private Long candidateId;

    @Nationalized
    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "NVARCHAR(200)"
    )
    private String name;

    @Nationalized
    @Column(
        name = "email",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String email;

    @Nationalized
    @Column(
        name = "phone",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String phone;

    @Nationalized
    @Column(
        name = "resume_url",
        nullable = true,
        columnDefinition = "NVARCHAR(500)"
    )
    private String resumeUrl;

    @Nationalized
    @Column(
        name = "source",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String source;

    // CREATE TABLE Candidate (
    //     candidate_id   BIGINT PRIMARY KEY,
    //     name           VARCHAR(200) NOT NULL,
    //     email          VARCHAR(255),
    //     phone          VARCHAR(50),
    //     resume_url     VARCHAR(500),
    //     source         VARCHAR(100)
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
