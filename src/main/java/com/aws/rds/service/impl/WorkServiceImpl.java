package com.aws.rds.service.impl;

import com.aws.rds.dto.WorkResponseDto;
import com.aws.rds.entity.Work;
import com.aws.rds.mapper.WorkMapper;
import com.aws.rds.repository.WorkRepository;
import com.aws.rds.service.WorkService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;
    private WorkMapper workMapper;

    @Override
    public List<WorkResponseDto> listWork() {
        return workRepository
                .findAll()
                .stream()
                .map(workMapper::toWorkResponseDto)
                .toList();
    }

    @Override
    public void createWork(String name) {
        workRepository
            .save(
                Work
                    .builder()
                    .name(name)
                    .build()
            );
    }

    @Override
    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }
}
