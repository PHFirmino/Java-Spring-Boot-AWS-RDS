package com.aws.rds.mapper;

import com.aws.rds.dto.WorkResponseDto;
import com.aws.rds.entity.Work;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkMapper {
    WorkResponseDto toWorkResponseDto(Work work);
}
