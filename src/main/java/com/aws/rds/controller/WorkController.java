package com.aws.rds.controller;

import com.aws.rds.dto.RDSRequestDto;
import com.aws.rds.dto.RDSResponseDto;
import com.aws.rds.dto.WorkResponseDto;
import com.aws.rds.service.RDSService;
import com.aws.rds.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
@AllArgsConstructor
public class WorkController {

    private WorkService workService;

    @GetMapping("/listWork")
    public ResponseEntity<List<WorkResponseDto>> listWork() {
        return ResponseEntity.status(HttpStatus.OK).body(workService.listWork());
    }

    @PostMapping("/createWork")
    public ResponseEntity<Void> createWork(@RequestBody String name) {
        workService.createWork(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteWork")
    public ResponseEntity<Void> deleteWork(@RequestBody Long id) {
        workService.deleteWork(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}