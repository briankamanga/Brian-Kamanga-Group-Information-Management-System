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
    name = "project",
    schema = "process",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_project_company_system_id_project_code",
            columnNames = {"company_system_id", "project_code"}
        )
    }
)
public class Project {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "project_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long projectId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "company_system_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_project_company_system_id"
        )
    )
    private CompanySystem companySystem;

    @Nationalized
    @Column(
        name = "project_code",
        nullable = false,
        columnDefinition = "VARCHAR(50)"
    )
    private String projectCode;

    @Nationalized
    @Column(
        name = "project_name",
        nullable = false,
        columnDefinition = "VARCHAR(100)"
    )
    private String projectName;

    @Nationalized
    @Column(
        name = "project_description",
        columnDefinition = "VARCHAR(max)"
    )
    private String projectDescription;

    @Nationalized
    @Column(
        name = "project_status",
        nullable = false,
        columnDefinition = "VARCHAR(50) CONSTRAINT chk_project_status CHECK (project_status IN ('PLANNED', 'IN_PROGRESS', 'COMPLETED', 'ON_HOLD', 'CANCELLED'))"
    )
    @ColumnDefault("'PLANNED'")
    private String projectStatus;

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
        mappedBy = "project",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    private List<ProjectTask> projectTasks;


    @OneToMany(
        mappedBy = "project",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    private List<ProjectTimeEntry> projectTimeEntries;

}
