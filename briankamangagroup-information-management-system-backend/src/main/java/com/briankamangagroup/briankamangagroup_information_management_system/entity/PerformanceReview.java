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
    name = "performance_review",
    schema = "human_resource"
)
public class PerformanceReview {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "performance_review_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long performanceReviewId;


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
            name = "fk_performance_review_employee_id"
        )
    )
    private Employee employee;


    @Nationalized
    @Column(
        name = "period",
        nullable = false,
        columnDefinition = "NVARCHAR(100)"
    )
    private String period;


    @Nationalized
    @Column(
        name = "goals",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String goals;




    @Nationalized
    @Column(
        name = "rating",
        nullable = true,
        columnDefinition = "NVARCHAR(100)"
    )
    private String rating;



    // Foreign Key to Employee Entity as reviewer
    // private Long reviewerId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = true
    )
    @JoinColumn(
        name = "reviewer_id",
        nullable = true,
        foreignKey = @ForeignKey(
            name = "fk_performance_review_employee_reviewer_id"
        )
    )
    private Employee reviewerEmployee;


    // CREATE TABLE PerformanceReview (
    //     review_id     BIGINT PRIMARY KEY,
    //     employee_id   BIGINT NOT NULL,
    //     period        VARCHAR(50) NOT NULL,
    //     goals         JSON,
    //     rating        VARCHAR(50),
    //     reviewer_id   BIGINT,

    //     CONSTRAINT fk_review_employee
    //         FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),

    //     CONSTRAINT fk_review_reviewer
    //         FOREIGN KEY (reviewer_id) REFERENCES Employee(employee_id)
    // );








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
