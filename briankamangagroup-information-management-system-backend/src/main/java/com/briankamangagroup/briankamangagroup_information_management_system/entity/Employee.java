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
    name = "employee",
    schema = "human_resource"
)
public class Employee {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "employee_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long employeeId;

    @Nationalized
    @Column(
        name = "first_name",
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String firstName;

    @Nationalized
    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String lastName;


    @Nationalized
    @Column(
        name = "preferred_name",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String preferredName;

    @Nationalized
    @Column(
        name = "email",
        nullable = false,
        unique = true,
        columnDefinition = "NVARCHAR(255)"
    )
    private String email;

    @Nationalized
    @Column(
        name = "phone",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String phone;

    @Nationalized
    @Column(
        name = "date_of_birth",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime dateOfBirth;

    @Nationalized
    @Column(
        name = "hire_date",
        nullable = false,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime hireDate;

    @Nationalized
    @Column(
        name = "termination_date",
        nullable = true,
        columnDefinition = "DATETIME2"
    )
    private LocalDateTime terminationDate;

    @Nationalized
    @Column(
        name = "employment_status",
        nullable = false,
        columnDefinition = "NVARCHAR(50)"
    )
    private String employmentStatus;



    // OneToMany - Self Reference
    @OneToMany(
        mappedBy = "employeeManager",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Employee> employeeManagers;



    // Foreign Keys
    // private Long jobId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "job_id",
        foreignKey = @ForeignKey(
            name = "fk_employee_job_id"
        )
    )
    private JobPosition jobPosition;



    // Foreign Keys
    // private Long departmentId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "department_id",
        foreignKey = @ForeignKey(
            name = "fk_employee_department_id"
        )
    )
    private Department department;



    // Foreign Keys - Self Reference
    // private Long managerId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "manager_id",
        foreignKey = @ForeignKey(
            name = "fk_employee_manager_id"
        )
    )
    private Employee employeeManager;




    // Foreign Keys
    // private Long locationId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "location_id",
        foreignKey = @ForeignKey(
            name = "fk_employee_location_id"
        )
    )
    private Location location;



    // Foreign Keys
    // private Long costCenterId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "cost_center_id",
        foreignKey = @ForeignKey(
            name = "fk_employee_cost_center_id"
        )
    )
    private CostCenter costCenter;





    @Nationalized
    @Column(
        name = "custom_fields",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String customFields;

    // CREATE TABLE Employee (
    //     employee_id        BIGINT PRIMARY KEY,
    //     first_name         VARCHAR(100) NOT NULL,
    //     last_name          VARCHAR(100) NOT NULL,
    //     preferred_name     VARCHAR(100),
    //     email              VARCHAR(255) UNIQUE NOT NULL,
    //     phone              VARCHAR(50),
    //     date_of_birth      DATE,
    //     hire_date          DATE NOT NULL,
    //     termination_date   DATE,
    //     employment_status  VARCHAR(50) NOT NULL,
    //     job_id             BIGINT,
    //     department_id      BIGINT,
    //     manager_id         BIGINT,
    //     location_id        BIGINT,
    //     cost_center_id     BIGINT,
    //     custom_fields      JSON,

    //     CONSTRAINT fk_employee_job
    //         FOREIGN KEY (job_id) REFERENCES Job(job_id),

    //     CONSTRAINT fk_employee_department
    //         FOREIGN KEY (department_id) REFERENCES Department(department_id),

    //     CONSTRAINT fk_employee_manager
    //         FOREIGN KEY (manager_id) REFERENCES Employee(employee_id),

    //     CONSTRAINT fk_employee_location
    //         FOREIGN KEY (location_id) REFERENCES Location(location_id),

    //     CONSTRAINT fk_employee_cost_center
    //         FOREIGN KEY (cost_center_id) REFERENCES CostCenter(cost_center_id)
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





    // OneToMany with Compensation
    @OneToMany(
        mappedBy = "employee",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Compensation> compensations;


    // OneToMany with Payroll
    @OneToMany(
        mappedBy = "employee",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Payroll> payrolls;


    // OneToMany with TimeEntry
    @OneToMany(
        mappedBy = "employee",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TimeEntry> timeEntries;


    // OneToMany with Employee Id in LeaveRequest Entity
    @OneToMany(
        mappedBy = "employee",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<LeaveRequest> leaveRequestsEmployeeId;




    // OneToMany with Department headEmployeeId
    @OneToMany(
        mappedBy = "headEmployee",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Department> departments;



    // OneToMany with Approver Id in LeaveRequest Entity
    @OneToMany(
        mappedBy = "approver",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<LeaveRequest> leaveRequestsApproverId;


}
