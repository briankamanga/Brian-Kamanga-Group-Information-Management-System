package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpTestDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.EmpTest;

public class EmpTestMapper {
    public static EmpTest mapToEmpTest(EmpTestDto empTestDto){
        return new EmpTest(
            empTestDto.getId(),
            empTestDto.getFName(),
            empTestDto.getLName(),
            empTestDto.getEmail()
        );
    }

    public static EmpTestDto mapEmpTestDto(EmpTest empTest){
        return new EmpTestDto(
            empTest.getId(),
            empTest.getFName(),
            empTest.getLName(),
            empTest.getEmail()
        );
    }
}
