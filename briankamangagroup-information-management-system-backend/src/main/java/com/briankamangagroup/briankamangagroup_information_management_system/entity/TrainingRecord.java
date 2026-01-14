package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import java.time.LocalDate;
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
    name = "training_record",
    schema = "human_resource"
)
public class TrainingRecord {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "training_record_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long trainingRecordId;

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
            name = "fk_training_record_employee_id"
        )
    )
    private Employee employee;



    @Nationalized
    @Column(
        name = "course_name",
        nullable = false,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String courseName;



    @Nationalized
    @Column(
        name = "provider",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String provider;



    @Nationalized
    @Column(
        name = "completion_date",
        nullable = true,
        columnDefinition = "DATE"
    )
    private LocalDate completionDate;




    @Nationalized
    @Column(
        name = "certificate_url",
        nullable = true,
        columnDefinition = "NVARCHAR(MAX)"
    )
    private String certificateUrl;

    // CREATE TABLE TrainingRecord (
    //     training_id      BIGINT PRIMARY KEY,
    //     employee_id      BIGINT NOT NULL,
    //     course_name      VARCHAR(200) NOT NULL,
    //     provider         VARCHAR(200),
    //     completion_date  DATE,
    //     certificate_url  VARCHAR(500),

    //     CONSTRAINT fk_training_employee
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






}
