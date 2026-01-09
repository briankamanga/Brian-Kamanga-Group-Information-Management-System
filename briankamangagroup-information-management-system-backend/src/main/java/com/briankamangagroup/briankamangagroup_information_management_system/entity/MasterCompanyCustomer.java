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
    name = "master_company_customer",
    schema = "briankamangagroup_information_management_system",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_master_company_customer_master_company_profile_header_id_company_code",
            columnNames = {"master_company_profile_header_id", "company_code"}
        )
    }
)

public class MasterCompanyCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "master_company_customer_id", 
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long masterCompanyCustomerId;

    @Nationalized
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "master_company_profile_header_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_master_company_customer_master_company_profile_header_master_company_profile_header_id"
        )
    )
    private MasterCompanyProfileHeader masterCompanyProfileHeader;

    @Nationalized
    @Column(
        name = "customer_code", 
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String customerCode;

    @Nationalized
    @Column(
        name = "customer_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String customerName;

    @Nationalized
    @Column(
        name = "customer_description",
        nullable = true,
        columnDefinition = "NVARCHAR(1000)"
    )
    private String customerDescription;

    @Nationalized
    @Column(
        name = "customer_address",
        nullable = true,
        columnDefinition = "NVARCHAR(1000)"
    )
    private String customerAddress;

    @Nationalized
    @Column(
        name = "customer_contact_person",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String customerContactPerson;

    @Nationalized
    @Column(
        name = "customer_phone_number",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String customerPhoneNumber;

    @Nationalized
    @Column(
        name = "customer_email",
        nullable = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String customerEmail;





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


