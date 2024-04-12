package com.witenconsulting.cqrs.api.controller;

import com.witenconsulting.cqrs.api.service.PersonService;
import com.witenconsulting.cqrs.common.BaseResponse;
import com.witenconsulting.cqrs.dto.PersonDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping("/")
    public ResponseEntity<BaseResponse<PersonDto>> createPerson(@Valid @RequestBody PersonDto dto) {
        BaseResponse<PersonDto> response = new BaseResponse<>(service.createPerson(dto));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<PersonDto>> updatePerson(@Valid @RequestBody PersonDto dto, @PathVariable("id") Long id) {
        BaseResponse<PersonDto> response = new BaseResponse<>(service.updatePerson(dto, id));
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
