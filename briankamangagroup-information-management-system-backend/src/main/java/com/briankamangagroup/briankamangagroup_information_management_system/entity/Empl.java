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
    name = "empl",
    schema = "inprogress",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_empl_email",
            columnNames = {
                "email"
            }
        )
    }
)
public class Empl {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "empl_id",
        nullable = false,
        updatable = false,
        columnDefinition = "int"
    )
    private Long id;

    @Nationalized
    @Column(
        name = "first_name",
        nullable = true,
        columnDefinition = "nvarchar(100)"
    )
    private String firstName;

    @Nationalized
    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "nvarchar(100)"
    )
    private String lastName;

    @Nationalized
    @Column(
        name = "email_address",
        nullable = false,
        unique = true,
        columnDefinition = "nvarchar(255)"
    )
    private String email;

}
