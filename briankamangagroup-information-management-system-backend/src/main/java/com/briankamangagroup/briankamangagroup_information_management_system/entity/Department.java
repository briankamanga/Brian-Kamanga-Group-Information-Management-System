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
    name = "department",
    schema = "human_resource",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_department_name_code",
            columnNames = {
                "name"
            }
        )
    }
)
public class Department {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "department_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long departmentId;

    @Nationalized
    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "NVARCHAR(200)"
    )
    private String name;

    @Nationalized
    @Column(
        name = "department_code",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String department_code;

    @Nationalized
    @Column(
        name = "description",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String description;



    // ManyToOne - Self Reference
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "parent_department_id",
        foreignKey = @ForeignKey(
            name = "fk_department_parent_department_id"
        )
    )
    private Department department;




    // Foreign Key to Employee Entity
    // private Long headEmployeeId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "head_employee_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_department_head_employee_id"
        )
    )
    private Employee headEmployee;

    // CREATE TABLE Department (
    //     department_id          BIGINT PRIMARY KEY,
    //     name                   VARCHAR(200) NOT NULL,
    //     parent_department_id   BIGINT,
    //     head_employee_id       BIGINT,

    //     CONSTRAINT fk_department_parent
    //         FOREIGN KEY (parent_department_id) REFERENCES Department(department_id),

    //     CONSTRAINT fk_department_head
    //         FOREIGN KEY (head_employee_id) REFERENCES Employee(employee_id)
    // );


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



    // OneToMany linked departments

    @OneToMany(
        mappedBy = "department",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Department> departments;


    // OneToMany linked employees
    @OneToMany(
        mappedBy = "department",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employees;


    // OneToMany linked JobRequisition
    @OneToMany(
        mappedBy = "department",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<JobRequisition> jobRequisitions;


}
