package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import com.briankamangagroup.briankamangagroup_information_management_system.service.EmployeePracticeService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmployeePracticeDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.EmployeePractice;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.EmployeePracticeMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.EmployeePracticeRepository;

@Service
@AllArgsConstructor
public class EmployeePracticeServiceImpl implements EmployeePracticeService {
    private EmployeePracticeRepository employeePracticeRepository;

	@Override
	public EmployeePracticeDto createEmployeePractice(EmployeePracticeDto employeePracticeDto) {
		EmployeePractice employeePractice = EmployeePracticeMapper.mapToEmployeePractice(employeePracticeDto);
        EmployeePractice savedEmployeePractice = employeePracticeRepository.save(employeePractice);
        return EmployeePracticeMapper.mapToEmployeePracticeDto(savedEmployeePractice);
	}

}
