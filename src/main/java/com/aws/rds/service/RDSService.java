package com.aws.rds.service;

import com.aws.rds.dto.RDSRequestDto;
import com.aws.rds.dto.RDSResponseDto;

import java.util.List;

public interface RDSService {
    List<RDSResponseDto> listRds();
    void createRds(RDSRequestDto rdsRequestDto);
    void deleteRds(String dbInstanceIdentifier);
}
