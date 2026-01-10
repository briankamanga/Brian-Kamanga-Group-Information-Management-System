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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "company_system",
    schema = "briankamangagroup_information_management_system",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_company_system_master_company_profile_header_id_system_code",
            columnNames = {
                "master_company_profile_header_id",
                "system_code"
            }
        )
    }
)
public class CompanySystem {
    @Id
    @Column(
        name = "company_system_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companySystemId;

    @Nationalized
    @ManyToOne(
        fetch = FetchType.LAZY, 
        optional = false
    )
    @JoinColumn(
        name = "master_company_profile_header_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_company_system_master_company_profile_header_master_company_profile_header_id"
        )
    )
    private MasterCompanyProfileHeader masterCompanyProfileHeader;

    @Nationalized
    @Column(
        name = "system_code",
        nullable = false,
        columnDefinition = "NVARCHAR(50)"
    )
    private String systemCode;

    @Nationalized
    @Column(
        name = "system_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String systemName;

    @Nationalized
    @Column(
        name = "system_description",
        columnDefinition = "NVARCHAR(max)"
    )
    private String systemDescription;

    @Nationalized
    @Column(
        name = "version",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String version;

    @Nationalized
    @Column(
        name = "status",
        nullable = false,
        columnDefinition = "NVARCHAR(50) CONSTRAINT chk_company_system_status CHECK (status IN ('Initiated', 'Development', 'In Progress', 'Completed', 'Testing', 'Deployed'))"
    )
    private String status;

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
        mappedBy = "companySystem",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MasterSystemUser> masterSystemUsers;


    @OneToMany(
        mappedBy = "companySystem",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MasterSystemRole> masterSystemRoles;


    @OneToMany(
        mappedBy = "companySystem",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Project> projects;
    
}
