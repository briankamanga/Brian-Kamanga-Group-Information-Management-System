package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpTestDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmpTestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/emptest")
public class EmpTestController {
    private EmpTestService empTestService;

    @PostMapping
    public ResponseEntity<EmpTestDto> createEmpTest(@RequestBody EmpTestDto empTestDto){
        EmpTestDto createdEmpTest = empTestService.creaEmpTest(empTestDto);
        return new ResponseEntity<>(createdEmpTest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpTestDto> getEmpTestById(@PathVariable("id") Long empTestId){
        EmpTestDto selectedEmpTest = empTestService.getEmpTestById(empTestId);
        return ResponseEntity.ok(selectedEmpTest);
    }

    @GetMapping
    public ResponseEntity<List<EmpTestDto>> getAllEmpTests(){
        List<EmpTestDto> selectedEmpTests = empTestService.getAllEmpTest();
        return ResponseEntity.ok(selectedEmpTests);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmpTestDto> updateEmpTest(@PathVariable("id") Long empTestId, 
                                                    @RequestBody EmpTestDto updatedEmpTestDto){
        EmpTestDto empTest = empTestService.updateEmpTest(updatedEmpTestDto, empTestId);
        return ResponseEntity.ok(empTest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmpTest(@PathVariable("id") Long empTestId){
        empTestService.deleteEmpTest(empTestId);
        return ResponseEntity.ok("EmpTest with ID " + empTestId + " deleted successfully!");
    }

}
