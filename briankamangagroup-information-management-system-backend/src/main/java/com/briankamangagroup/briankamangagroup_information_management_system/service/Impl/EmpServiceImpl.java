package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.Emp;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.EmpMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.EmpRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmpService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService{
    private EmpRepository empRepository;


    @Override
    public EmpDto createEmp(EmpDto empDto) {
        Emp emp = EmpMapper.mapToEmp(empDto);
        Emp savedEmp = empRepository.save(emp);
        return EmpMapper.mapToEmpDto(savedEmp);
    }
}
