package com.briankamangagroup.briankamangagroup_information_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briankamangagroup.briankamangagroup_information_management_system.dto.EmplDto;
import com.briankamangagroup.briankamangagroup_information_management_system.service.EmplService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/bkg-api/empls")
public class EmplController {
    private EmplService emplService;

    @PostMapping
    public ResponseEntity<EmplDto> createEmpl(@RequestBody EmplDto emplDto){
        EmplDto createdEmpl = emplService.createEmpl(emplDto);
        return new ResponseEntity<>(createdEmpl, HttpStatus.CREATED);
    }

}
