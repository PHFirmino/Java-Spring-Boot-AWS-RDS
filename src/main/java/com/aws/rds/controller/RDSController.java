package com.aws.rds.controller;

import com.aws.rds.dto.RDSRequestDto;
import com.aws.rds.dto.RDSResponseDto;
import com.aws.rds.service.RDSService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rds")
@AllArgsConstructor
public class RDSController {

    private RDSService rdsService;

    @GetMapping("/listRds")
    public ResponseEntity<List<RDSResponseDto>> listRds() {
        return ResponseEntity.status(HttpStatus.OK).body(rdsService.listRds());
    }

    @PostMapping("/createRds")
    public ResponseEntity<Void> createRds(RDSRequestDto rdsRequestDto) {
        rdsService.createRds(rdsRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deleteRds")
    public ResponseEntity<Void> deleteRds(String dbInstanceIdentifier) {
        rdsService.deleteRds(dbInstanceIdentifier);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}