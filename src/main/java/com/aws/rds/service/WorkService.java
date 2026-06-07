package com.aws.rds.service;

import com.aws.rds.dto.WorkResponseDto;

import java.util.List;

public interface WorkService {
    List<WorkResponseDto> listWork();
    void createWork(String name);
    void deleteWork(Long id);
}
