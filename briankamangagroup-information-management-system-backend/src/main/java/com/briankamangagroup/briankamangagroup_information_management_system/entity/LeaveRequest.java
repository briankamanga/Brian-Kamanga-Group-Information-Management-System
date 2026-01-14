package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDate;
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
    name = "leave_request",
    schema = "human_resource"
)
public class LeaveRequest {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "leave_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long leaveId;



    // Foreign Key to Employee Entity
    // private Long employeeId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "employee_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_leave_request_employee_id"
        )
    )
    private Employee employee;


    @Nationalized
    @Column(
        name = "leave_type",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String leaveType;



    @Nationalized
    @Column(
        name = "start_date",
        nullable = true,
        columnDefinition = "DATE"
    )
    private LocalDate startDate;

    

    @Nationalized
    @Column(
        name = "end_date",
        nullable = true,
        columnDefinition = "DATE"
    )
    private LocalDate endDate;



    @Nationalized
    @Column(
        name = "status",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String status;


    // Foreign Key to Employee Entity - approver
    // private Long approverId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "employee_id",
        foreignKey = @ForeignKey(
            name = "fk_leave_request_approver_id"
        )
    )
    private Employee approver;


    // CREATE TABLE LeaveRequest (
    //     leave_id      BIGINT PRIMARY KEY,
    //     employee_id   BIGINT NOT NULL,
    //     leave_type    VARCHAR(100) NOT NULL,
    //     start_date    DATE NOT NULL,
    //     end_date      DATE NOT NULL,
    //     status        VARCHAR(50),
    //     approver_id   BIGINT,

    //     CONSTRAINT fk_leave_employee
    //         FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),

    //     CONSTRAINT fk_leave_approver
    //         FOREIGN KEY (approver_id) REFERENCES Employee(employee_id)
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



    // OneToMany - Self-Referential relationship
    @OneToMany(
        mappedBy = "leaveRequests",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<LeaveRequest> leaveRequests;



}
