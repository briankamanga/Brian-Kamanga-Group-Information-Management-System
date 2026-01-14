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
    name = "time_entry",
    schema = "human_resource"
)  
public class TimeEntry {
    @Id
    @GeneratedValue
    (
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "time_entry_id",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long timeEntryId;

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
            name = "fk_timeentry_employee"
        )   
    )
    private Employee employee;


    @Nationalized
    @Column(
        name = "date",
        nullable = false,
        columnDefinition = "DATE"
    )   
    private LocalDate date;

    @Nationalized
    @Column(
        name = "hours",
        nullable = false,
        columnDefinition = "MONEY"
    )
    private Double hours;
    


    // Foreign Key to Project entity
    // private Long projectId;
    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false    
    )
    @JoinColumn(
        name = "project_id",
        nullable = false,
        foreignKey = @ForeignKey(
            name = "fk_timeentry_project"
        )
    )
    private Project project;


    @Nationalized
    @Column(
        name = "approval_status",
        nullable = true,
        columnDefinition = "NVARCHAR(50)"
    )
    private String approvalStatus;

    // CREATE TABLE TimeEntry (
    //     time_entry_id   BIGINT PRIMARY KEY,
    //     employee_id     BIGINT NOT NULL,
    //     date            DATE NOT NULL,
    //     hours           DECIMAL(5,2) NOT NULL,
    //     project_id      BIGINT,
    //     approval_status VARCHAR(50),

    //     CONSTRAINT fk_timeentry_employee
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




    // OneToMany - Self-referential relationship
    @OneToMany(
        mappedBy = "timeEntries",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TimeEntry> timeEntries;



}
