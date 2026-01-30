package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    name = "compensation",
    schema = "human_resource"
)
public class Compensation {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "compensation_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long compensationId;




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
            name = "fk_compensation_employee"
        )
    )
    private Employee employee;





    @Nationalized
    @Column(
        name = "base_salary",
        nullable = false,
        columnDefinition = "MONEY"
    )
    private Double baseSalary;

    @Nationalized
    @Column(
        name = "currency",
        nullable = false,
        columnDefinition = "NVARCHAR(10)"
    )
    private String currency;


    @Nationalized
    @Column(
        name = "pay_frequency",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String payFrequency;

    @Nationalized
    @Column(
        name = "bonus_target",
        nullable = true,
        columnDefinition = "MONEY"
    )
    private Double bonusTarget;

    @Nationalized
    @Column(
        name = "effective_start",
        nullable = false,
        columnDefinition = "DATE"
    )
    private String effectiveStart;

    @Nationalized
    @Column(
        name = "effective_end",
        nullable = true,
        columnDefinition = "DATE"
    )
    private String effectiveEnd;

    // CREATE TABLE Compensation (
    //     compensation_id   BIGINT PRIMARY KEY,
    //     employee_id       BIGINT NOT NULL,
    //     base_salary       DECIMAL(12,2) NOT NULL,
    //     currency          VARCHAR(10) NOT NULL,
    //     pay_frequency     VARCHAR(50),
    //     bonus_target      DECIMAL(5,2),
    //     effective_start   DATE NOT NULL,
    //     effective_end     DATE,

    //     CONSTRAINT fk_compensation_employee
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






    // // Entity self reference object
    // private Compensation compensation;

    // // OneToMany Relationship - self-referencing example
    // @OneToMany(
    //     fetch = FetchType.LAZY,
    //     mappedBy = "compensation",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // private List<Compensation> compensations;   

}
