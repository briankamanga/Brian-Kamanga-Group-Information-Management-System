package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmployeePracticeDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmployeePracticeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employeepractice")
public class EmployeePracticeController {
    private EmployeePracticeService employeePracticeService;


    @PostMapping
    public ResponseEntity<EmployeePracticeDto> createEmployeePractice(@RequestBody EmployeePracticeDto employeePracticeDto){
        EmployeePracticeDto createdEmployeePractice = employeePracticeService.createEmployeePractice(employeePracticeDto);
        return new ResponseEntity<>(createdEmployeePractice, HttpStatus.CREATED);
    }



}
