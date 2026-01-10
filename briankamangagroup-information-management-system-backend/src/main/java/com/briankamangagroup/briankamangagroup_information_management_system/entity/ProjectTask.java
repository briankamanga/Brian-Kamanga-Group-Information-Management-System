package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.CheckConstraint;
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
import jakarta.persistence.UniqueConstraint;
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
    name = "project_task",
    schema = "process",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_project_task_project_id_task_code",
            columnNames = {"project_id", "task_code"}
        )
    }
    // ,
    // checkConstraints = {
    //     @CheckConstraint(
    //         name = "CK_your_table_start_end",
    //         constraint = "end_date IS NULL OR end_date >= start_date"
                        
    //     )
    // }
)
public class ProjectTask {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "project_task_id",
        nullable = false,
        updatable = false
    )
    private Long projectTaskId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "project_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_project_task_project_id"
        )
    )
    private Project project;

    @Nationalized
    @Column(
        name = "task_code",
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String taskCode;

    @Nationalized
    @Column(
        name = "task_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String taskName;

    @Nationalized
    @Column(
        name = "task_description",
        nullable = true,
        columnDefinition = "NVARCHAR(max)"
    )
    private String taskDescription;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = true
    )
    @JoinColumn(
        name = "assigned_to_user_id",
        nullable = true,
        foreignKey = @ForeignKey(
            name = "fk_project_task_assigned_to_user_id"
        )
    )
    private MasterSystemUser assignedToUserId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = true
    )
    @JoinColumn(
        name = "master_company_customer_id",
        nullable = true,
        foreignKey = @ForeignKey(
            name = "fk_project_task_master_company_customer_id"
        )
    )
    private MasterCompanyCustomer masterCompanyCustomer;

    @Nationalized
    @Column(
        name = "task_status",
        nullable = true,
        columnDefinition = "NVARCHAR(50) CONSTRAINT chk_project_task_task_status CHECK (task_status IN ('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED', 'ON_HOLD', 'CANCELLED'))"
    )
    private String taskStatus;

    @Column(
        name = "start_date",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime startDate;

    @Column(
        name = "end_date",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime endDate;

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


    @OneToMany(
        mappedBy = "projectTask",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ProjectTimeEntry> projectTimeEntries;

}
