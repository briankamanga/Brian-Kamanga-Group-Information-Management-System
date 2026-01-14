package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.math.BigDecimal;
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
    name = "payroll",
    schema = "human_resource"
)
public class Payroll {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "payroll_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long payrollId;



    // Foreign Key to Employee entity
    // private Long employeeId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "employee_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_payroll_employee"
        )
    )
    private Employee employee;





    @Nationalized
    @Column(
        name = "period_start",
        nullable = false,
        columnDefinition = "DATE"
    )
    private LocalDate periodStart;

    @Nationalized
    @Column(
        name = "period_end",
        nullable = false,
        columnDefinition = "DATE"
    )
    private LocalDate periodEnd;

    @Nationalized
    @Column(
        name = "gross_pay",
        nullable = true,
        columnDefinition = "MONEY"
    )
    private BigDecimal grossPay;

    @Nationalized
    @Column(
        name = "net_pay",
        nullable = true,
        columnDefinition = "MONEY"
    )
    private BigDecimal netPay;

    @Nationalized
    @Column(
        name = "deductions",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String deductions; // JSON stored as String

    @Nationalized
    @Column(
        name = "status",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String status;

    // CREATE TABLE Payroll (
    //     payroll_id     BIGINT PRIMARY KEY,
    //     employee_id    BIGINT NOT NULL,
    //     period_start   DATE NOT NULL,
    //     period_end     DATE NOT NULL,
    //     gross_pay      DECIMAL(12,2),
    //     net_pay        DECIMAL(12,2),
    //     deductions     JSON,
    //     status         VARCHAR(50),

    //     CONSTRAINT fk_payroll_employee
    //         FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
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




    // OneToMany - Self-referencing
    @OneToMany(
        mappedBy = "parentPayrolls",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Payroll> parentPayrolls;
}
