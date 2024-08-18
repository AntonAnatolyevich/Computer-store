package ru.akhramenko.computerstore.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.computerstore.dto.specification.SpecificationRequest;
import ru.akhramenko.computerstore.dto.specification.SpecificationResponse;
import ru.akhramenko.computerstore.entity.Specification;
import ru.akhramenko.computerstore.repo.SpecificationRepo;
import ru.akhramenko.computerstore.utils.exception.ResourceNotFoundException;
import ru.akhramenko.computerstore.utils.mapper.SpecificationMapper;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationRepo specificationRepo;
    private final SpecificationMapper specificationMapper;

    public List<SpecificationResponse> findAll() {
        return specificationRepo.findAll().stream()
                .map(specificationMapper::toSpecificationResponse)
                .collect(Collectors.toList());
    }

    public SpecificationResponse findById(UUID id) {
        Specification specification = specificationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return specificationMapper.toSpecificationResponse(specification);
    }

    @Transactional
    public SpecificationResponse create(SpecificationRequest specificationRequest) {
        Specification specification = specificationMapper.toSpecification(specificationRequest);
        Specification savedSpecification = specificationRepo.save(specification);
        return specificationMapper.toSpecificationResponse(savedSpecification);
    }

    @Transactional
    public SpecificationResponse update(UUID id, SpecificationRequest specificationRequest) {
        Specification existingSpecification = specificationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        Specification updatedSpecification = specificationMapper.toSpecification(specificationRequest);
        updatedSpecification.setId(existingSpecification.getId());
        specificationRepo.save(updatedSpecification);
        return specificationMapper.toSpecificationResponse(updatedSpecification);

    }

    @Transactional
    public void delete(UUID id) {
        specificationRepo.deleteById(id);
    }
}
