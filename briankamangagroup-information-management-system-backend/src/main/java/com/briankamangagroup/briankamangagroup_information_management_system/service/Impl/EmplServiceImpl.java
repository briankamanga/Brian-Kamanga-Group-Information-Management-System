package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmplDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Empl;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.EmplMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.EmplRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmplService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmplServiceImpl implements EmplService{
    private EmplRepository emplRepository;

    @Override
    public EmplDto createEmpl(EmplDto emplDto) {
        Empl empl = EmplMapper.mapToEmpl(emplDto);
        Empl savedEmpl = emplRepository.save(empl);
        return EmplMapper.mapToEmplDto(savedEmpl);
    }

}
