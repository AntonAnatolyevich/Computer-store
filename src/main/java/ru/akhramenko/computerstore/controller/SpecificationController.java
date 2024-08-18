package ru.akhramenko.computerstore.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.akhramenko.computerstore.dto.specification.SpecificationRequest;
import ru.akhramenko.computerstore.dto.specification.SpecificationResponse;
import ru.akhramenko.computerstore.service.SpecificationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specifications")
public class SpecificationController {

    private final SpecificationService specificationService;

    @GetMapping("")
    public List<SpecificationResponse> getAllSpecifications() {
        return specificationService.findAll();
    }

    @GetMapping("/{id}")
    public SpecificationResponse getSpecificationById(@PathVariable UUID id) {
        return specificationService.findById(id);
    }

    @PostMapping("")
    public SpecificationResponse addNewSpecification(@RequestBody SpecificationRequest specificationRequest) {
        return specificationService.create(specificationRequest);
    }

    @PatchMapping("/{id}")
    public SpecificationResponse updateSpecification(@PathVariable UUID id, @RequestBody SpecificationRequest specificationRequest) {
        return specificationService.update(id, specificationRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecificationById(@PathVariable UUID id) {
        specificationService.delete(id);
    }
}
