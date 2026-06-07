package com.aws.rds.service.impl;

import com.aws.rds.dto.RDSRequestDto;
import com.aws.rds.dto.RDSResponseDto;
import com.aws.rds.mapper.RDSMapper;
import com.aws.rds.service.RDSService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.CreateDbInstanceRequest;
import software.amazon.awssdk.services.rds.model.DeleteDbInstanceRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class RDSServiceImpl implements RDSService {

    private RdsClient rdsClient;
    private RDSMapper rdsMapper;

    @Override
    public List<RDSResponseDto> listRds() {
        return rdsClient
                .describeDBInstances()
                .dbInstances()
                .stream()
                .map(rdsMapper::toRdsResponseDto)
                .toList();
    }

    @Override
    public void createRds(RDSRequestDto rdsRequestDto) {
        rdsClient.createDBInstance(
            CreateDbInstanceRequest
                .builder()
                .dbInstanceIdentifier(rdsRequestDto.getDbInstanceIdentifier())
                .dbInstanceClass(rdsRequestDto.getDbInstanceClass())
                .engine(rdsRequestDto.getEngine())
                .masterUsername(rdsRequestDto.getMasterUsername())
                .masterUserPassword(rdsRequestDto.getMasterUserPassword())
                .allocatedStorage(rdsRequestDto.getAllocatedStorage())
                .dbName(rdsRequestDto.getDbName())
                .build()
        );
    }

    @Override
    public void deleteRds(String dbInstanceIdentifier) {
        rdsClient.deleteDBInstance(
                DeleteDbInstanceRequest
                    .builder()
                    .dbInstanceIdentifier(dbInstanceIdentifier)
                    .build()
        );
    }
}
