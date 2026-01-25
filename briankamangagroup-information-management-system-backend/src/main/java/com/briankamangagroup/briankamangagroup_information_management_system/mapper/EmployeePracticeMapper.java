package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmployeePracticeDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.EmployeePractice;

public class EmployeePracticeMapper {
    public static EmployeePracticeDto mapToEmployeePracticeDto(EmployeePractice employeePractice){
        return new EmployeePracticeDto(
            employeePractice.getId(),
            employeePractice.getFirstName(),
            employeePractice.getLastName(),
            employeePractice.getEmail()
        );
    }

    public static EmployeePractice mapToEmployeePractice(EmployeePracticeDto employeePracticeDto){
        return new EmployeePractice(
            employeePracticeDto.getId(),
            employeePracticeDto.getFirstName(),
            employeePracticeDto.getLastName(),
            employeePracticeDto.getEmail()
        );
    }

}
