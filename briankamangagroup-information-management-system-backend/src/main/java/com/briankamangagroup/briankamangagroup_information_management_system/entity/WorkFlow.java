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
    name = "work_flow",
    schema = "human_resource"
)
public class WorkFlow {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "workflow_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long workflowId;

    @Nationalized
    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "NVARCHAR(200)"
    )
    private String name;

    @Nationalized
    @Column(
        name = "work_flow_trigger",
        nullable = true,
        columnDefinition = "NVARCHAR(200)"
    )
    private String trigger;

    @Nationalized
    @Column(
        name = "actions",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String actions;


    @Column(
        name = "active",
        nullable = true,
        columnDefinition = "BIT"
    )
    @ColumnDefault("1")
    private Boolean active;
    

    // CREATE TABLE Workflow (
    //     workflow_id   BIGINT PRIMARY KEY,
    //     name          VARCHAR(200) NOT NULL,
    //     trigger       VARCHAR(200),
    //     actions       JSON,
    //     active        BIT NOT NULL
    // );




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



}
