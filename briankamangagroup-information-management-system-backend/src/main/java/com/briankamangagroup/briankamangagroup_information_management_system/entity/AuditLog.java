package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;

public class AuditLog {
    private Long auditId;
    private String entity;
    private Long entityId;
    private String action;
    private LocalDateTime timeStamp;

    // Foreign Key to Employee Entity
    private Long userId;
    private String changes;

    // CREATE TABLE AuditLog (
    //     audit_id     BIGINT PRIMARY KEY,
    //     entity       VARCHAR(100) NOT NULL,
    //     entity_id    BIGINT NOT NULL,
    //     action       VARCHAR(50) NOT NULL,
    //     timestamp    DATETIME NOT NULL,
    //     user_id      BIGINT,
    //     changes      JSON,

    //     CONSTRAINT fk_audit_user
    //         FOREIGN KEY (user_id) REFERENCES Employee(employee_id)
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
