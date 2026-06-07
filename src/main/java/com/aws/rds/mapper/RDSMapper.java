package com.aws.rds.mapper;

import com.aws.rds.dto.RDSResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import software.amazon.awssdk.services.rds.model.DBInstance;

@Mapper(componentModel = "spring")
public interface RDSMapper {
    @Mapping(target = "dbInstanceIdentifier", expression = "java(dbInstance.dbInstanceIdentifier())")
    RDSResponseDto toRdsResponseDto(DBInstance dbInstance);
}
