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
    name = "master_system_role",
    schema = "system",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_master_system_role_company_system_id_role_code",
            columnNames = {
                "company_system_id",
                "role_code"
            }
        )
        
    }
)
public class MasterSystemRole {
    @Id
    @GeneratedValue
    (
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "master_system_role_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long masterSystemRoleId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "company_system_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_master_system_role_company_system_id"
        )
    )
    private CompanySystem companySystem;

    @Nationalized
    @Column(
        name = "role_code",
        nullable = false,
        columnDefinition = "NVARCHAR(50)"
    )
    private String roleCode;

    @Nationalized
    @Column(
        name = "role_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String roleName;

    @Nationalized
    @Column(
        name = "role_description",
        nullable = true,
        columnDefinition = "NVARCHAR(500)"
    )
    private String roleDescription;

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
