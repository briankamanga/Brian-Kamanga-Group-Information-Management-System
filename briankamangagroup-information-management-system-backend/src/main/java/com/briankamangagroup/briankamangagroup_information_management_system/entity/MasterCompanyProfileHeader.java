package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    name = "master_company_profile_header",
    schema = "briankamangagroup_information_management_system",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_master_company_profile_header_company_code_company_name",
            columnNames = {"company_code", "company_name"}
        )
    }
)
public class MasterCompanyProfileHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "master_company_profile_header_id", 
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long masterCompanyProfileHeaderId;

    @Nationalized
    @Column(
        name = "company_code", 
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String companyCode;

    @Nationalized
    @Column(
        name = "company_name", 
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String companyName;

    @Nationalized
    @Column(
        name = "company_address", 
        nullable = true,
        columnDefinition = "NVARCHAR(1000)"
    )
    private String companyAddress;

    @Nationalized
    @Column(
        name = "company_logo_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String companyLogoUrl;

    @Nationalized
    @Column(
        name = "company_tagline", 
        nullable = false,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String companyTagline;

    @Nationalized
    @Column(
        name = "company_description", 
        nullable = false,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String companyDescription;

    @Nationalized
    @Column(
        name = "contact_email", 
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String contactEmail;

    @Nationalized
    @Column(
        name = "contact_phone_number", 
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String contactPhoneNumber;

    @Nationalized
    @Column(
        name = "website_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String websiteUrl;

    @Nationalized
    @Column(
        name = "facebook_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String facebookUrl;

    @Nationalized
    @Column(
        name = "twitter_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String twitterUrl;

    @Nationalized
    @Column(
        name = "linkedin_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String linkedinUrl;

    @Nationalized
    @Column(
        name = "instagram_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String instagramUrl;

    @Nationalized
    @Column(
        name = "youtube_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String youtubeUrl;

    @Nationalized
    @Column(
        name = "tiktok_url", 
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String tiktokUrl;

    @Nationalized
    @Column(
        name = "is_active", 
        nullable = false,
        columnDefinition = "BIT"
    )
    @ColumnDefault("1")
    private Boolean isActive;

    @Nationalized
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
        columnDefinition = "NVARCHAR(MAX)"
    )
    @ColumnDefault("SYSTEM_USER")
    private String createdBy;

    @Nationalized
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
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String modifiedBy;

    @Nationalized
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
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String deactivatedBy;

    // Reverse relationship with MasterCompanyCustomer
    @OneToMany(
        mappedBy = "masterCompanyProfileHeader",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MasterCompanyCustomer> masterCompanyCustomers;

    // Reverse relationship with CompanySystem
    @OneToMany(
        mappedBy = "masterCompanyProfileHeader",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<CompanySystem> companySystems;



    // Reverse relationship with MasterCompanyProductCategory
    @OneToMany(
        mappedBy = "masterCompanyProfileHeader",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MasterCompanyProductCategory> masterCompanyProductCategories;


}
