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
    name = "audit_log",
    schema = "human_resource"
)
public class AuditLog {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "audit_log_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long auditId;

    @Nationalized
    @Column(
        name = "entity",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String entity;

    @Nationalized
    @Column(
        name = "entity_id",
        nullable = false,
        columnDefinition = "INT"
    )
    private Long entityId;

    @Nationalized
    @Column(
        name = "action",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String action;

    @Nationalized
    @Column(
        name = "time_stamp",
        nullable = false,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime timeStamp;

    // Foreign Key to Employee Entity
    // private Long userId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = true
    )
    @JoinColumn(
        name = "user_id",
        nullable = true,
        foreignKey = @ForeignKey(
            name = "fk_audit_log_employee_id"
        )
    )
    private Employee employee;

    @Nationalized
    @Column(
        name = "changes",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
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
