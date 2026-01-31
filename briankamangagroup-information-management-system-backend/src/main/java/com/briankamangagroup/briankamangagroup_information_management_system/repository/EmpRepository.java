package com.briankamangagroup.briankamangagroup_information_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briankamangagroup.briankamangagroup_information_management_system.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {

}
