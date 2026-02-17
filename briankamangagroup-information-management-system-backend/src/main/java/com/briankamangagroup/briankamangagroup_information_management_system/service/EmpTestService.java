package com.briankamangagroup.briankamangagroup_information_management_system.service;

import java.util.List;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpTestDto;

public interface EmpTestService {
    public EmpTestDto creaEmpTest(EmpTestDto empTestDto);
    public EmpTestDto getEmpTestById(Long empTestId);
    public List<EmpTestDto> getAllEmpTest();
    public EmpTestDto updateEmpTest(EmpTestDto updatedEmpTestDto, Long empTestID);
    void deleteEmpTest(Long empTestIdToDelete);
}
