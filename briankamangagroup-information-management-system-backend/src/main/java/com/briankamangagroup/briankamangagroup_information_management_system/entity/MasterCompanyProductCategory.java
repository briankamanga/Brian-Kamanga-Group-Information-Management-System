package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

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
    name = "master_company_product_category",
    schema = "briankamangagroup_information_management_system",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_master_company_product_category_master_company_profile_header_id_product_category_code",
            columnNames = {
                "master_company_profile_header_id",
                "product_category_code"
            }
        )        
    }
)
public class MasterCompanyProductCategory {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "master_company_product_category_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long masterCompanyProductCategoryId;

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "master_company_profile_header_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_master_company_product_category_master_company_profile_header_id"
        )
    )
    private MasterCompanyProfileHeader masterCompanyProfileHeader;

    @Column(
        name = "product_category_code",
        nullable = false,
        columnDefinition = "NVARCHAR(50)"
    )
    private String productCategoryCode;

    @Column(
        name = "product_category_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String productCategoryName;

    @Column(
        name = "product_category_description",
        nullable = true,
        columnDefinition = "NVARCHAR(1000)"
    )
    private String productCategoryDescription;

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
