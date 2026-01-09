package com.briankamangagroup.briankamangagroup_information_management_system.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.Nationalized;


import jakarta.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
    name = "test_table_try",
    schema = "briankamangagroup_information_management_system"
)
public class TestTable_Try {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "test_table_try_id", 
        nullable = false,
        unique = true,
        updatable = false,
        columnDefinition = "INT"
    )
    private Long id;
    @Nationalized
    @Column(
        name = "test_table_try_name",
        nullable = false,
        columnDefinition = "NVARCHAR(255)"
    )
    private String name;

}
