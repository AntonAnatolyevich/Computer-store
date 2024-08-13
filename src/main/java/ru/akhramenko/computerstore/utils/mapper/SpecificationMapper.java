package ru.akhramenko.computerstore.utils.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.akhramenko.computerstore.dto.specification.SpecificationRequest;
import ru.akhramenko.computerstore.dto.specification.SpecificationResponse;
import ru.akhramenko.computerstore.entity.Specification;

@Component
@Mapper
public interface SpecificationMapper {
    Specification toSpecification(SpecificationRequest specificationRequest);
    SpecificationResponse toSpecificationResponse(Specification specification);
}
