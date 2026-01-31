package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmpDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmpService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/bkg-api/emps")
public class EmpController {
    private EmpService empService;

    @PostMapping
    public ResponseEntity<EmpDto> createEmp(@RequestBody EmpDto empDto){
        EmpDto createdEmp = empService.createEmp(empDto);
        return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
    }

}
