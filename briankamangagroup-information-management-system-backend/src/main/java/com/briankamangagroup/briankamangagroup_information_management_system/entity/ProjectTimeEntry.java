package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.math.BigDecimal;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
    name = "project_time_entry",
    schema = "process",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_project_time_entry_project_task_id_system_user_id_work_date",
            columnNames = {"project_task_id", "system_user_id", "work_date"}
        )
    }
)
public class ProjectTimeEntry {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "project_time_entry_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long projectTimeEntryId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "project_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_project_time_entry_project_id"
        )
    )
    private Project project;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "project_task_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_project_time_entry_project_task_id"
        )
    )
    private ProjectTask projectTask;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "system_user_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_project_time_entry_system_user_id"
        )
    )
    private MasterSystemUser masterSystemUser;

    @Nationalized
    @Column(
        name = "hours_logged",
        nullable = false,
        columnDefinition = "DECIMAL(5,2)"
    )
    private BigDecimal hoursLogged;

    @Nationalized
    @Column(
        name = "work_date",
        nullable = false,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime workDate;

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

}
