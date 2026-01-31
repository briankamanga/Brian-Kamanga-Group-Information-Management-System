package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Emp;

public class EmpMapper {
    public static EmpDto mapToEmpDto(Emp emp){
        return new EmpDto(
            emp.getId(),
            emp.getFirstName(),
            emp.getLastName(),
            emp.getEmail()
        );
    }

    public static Emp mapToEmp(EmpDto empDto){
        return new Emp(
            empDto.getId(),
            empDto.getFirstName(),
            empDto.getLastName(),
            empDto.getEmail()
        );
    }

}
