package com.briankamangagroup.briankamangagroup_information_management_system.mapper;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmplDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Empl;

public class EmplMapper {
    public static Empl mapToEmpl(EmplDto emplDto){
        return new Empl(
            emplDto.getId(),
            emplDto.getFirstName(),
            emplDto.getLastName(),
            emplDto.getEmail()
        );
    }

    public static EmplDto mapToEmplDto(Empl empl){
        return new EmplDto(
            empl.getId(),
            empl.getFirstName(),
            empl.getLastName(),
            empl.getEmail()
        );
    }

}
