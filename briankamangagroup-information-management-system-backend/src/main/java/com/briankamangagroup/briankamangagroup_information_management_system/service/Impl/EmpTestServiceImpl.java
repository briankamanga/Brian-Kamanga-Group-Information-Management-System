package com.briankamangagroup.briankamangagroup_information_management_system.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpTestDto;
import com.briankamangagroup.briankamangagroup_information_management_system.entity.EmpTest;
import com.briankamangagroup.briankamangagroup_information_management_system.exception.ResourceNotFoundException;
import com.briankamangagroup.briankamangagroup_information_management_system.mapper.EmpTestMapper;
import com.briankamangagroup.briankamangagroup_information_management_system.repository.EmpTestRepository;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmpTestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmpTestServiceImpl implements EmpTestService{
    private EmpTestRepository empTestRepository;

    @Override
    public EmpTestDto creaEmpTest(EmpTestDto empTestDto) {
        EmpTest empTestToSave = EmpTestMapper.mapToEmpTest(empTestDto);
        EmpTest savedEmpTest = empTestRepository.save(empTestToSave);
        return EmpTestMapper.mapEmpTestDto(savedEmpTest);
    }

    @Override
    public EmpTestDto getEmpTestById(Long empTestId) {
        EmpTest foundEmpTest = empTestRepository.findById(empTestId)
                .orElseThrow(
                    () -> new ResourceNotFoundException("EmpTest Entity with ID " + empTestId + " doesn't exist!")
                );
        return EmpTestMapper.mapEmpTestDto(foundEmpTest);
    }

    @Override
    public List<EmpTestDto> getAllEmpTest() {
        List<EmpTest> receivedEmpTests = empTestRepository.findAll();
        return receivedEmpTests.stream().map(
                                                (receivedEmpTest) -> EmpTestMapper.mapEmpTestDto(receivedEmpTest)
                                            )
                                            .collect(Collectors.toList());
    }

    @Override
    public EmpTestDto updateEmpTest(EmpTestDto updatedEmpTestDto, Long empTestID) {
        EmpTest empTestToUpdate = empTestRepository.findById(empTestID)
                    .orElseThrow(
                        () -> new ResourceNotFoundException("EmpTest Entity with ID \" + empTestId + \" doesn't exist!")
                    );
        empTestToUpdate.setFName(updatedEmpTestDto.getFName());
        empTestToUpdate.setLName(updatedEmpTestDto.getLName());
        empTestToUpdate.setEmail(updatedEmpTestDto.getEmail());

        EmpTest updatedEmpTest =  empTestRepository.save(empTestToUpdate);
        return EmpTestMapper.mapEmpTestDto(updatedEmpTest);

    }

    @Override
    public void deleteEmpTest(Long empTestIdToDelete) {
        empTestRepository.findById(empTestIdToDelete)
                        .orElseThrow(
                            () -> new ResourceNotFoundException("The selected Id " + empTestIdToDelete + " doesn't exist in the database!")
                        );
        empTestRepository.deleteById(empTestIdToDelete);
    }

}
