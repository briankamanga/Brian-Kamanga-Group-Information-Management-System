package com.briankamangagroup.briankamangagroup_information_management_system.entity;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    name = "EmployeeTest",
    schema = "InProgress",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_employeetest_email",
            columnNames = {"EmailAddress"}
        )
    }
)
public class EmpTest {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "EmployeeTestID",
        nullable = false,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long id;

    @Nationalized
    @Column(
        name = "FirstName",
        nullable = true,
        columnDefinition = "nvarchar(100)"
    )
    private String fName;

    @Nationalized
    @Column(
        name = "LastName",
        nullable = false,
        columnDefinition = "nvarchar(100)"
    )
    private String lName;

    @Nationalized
    @Column(
        name = "EmailAddress",
        nullable = false,
        columnDefinition = "nvarchar(255)"
    )
    private String email;
}
