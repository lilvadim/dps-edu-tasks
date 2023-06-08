package ru.nsu.vadim.booking.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.web.dto.Airport;
import ru.nsu.vadim.booking.web.dto.City;
import ru.nsu.vadim.booking.web.dto.LocalizedString;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        unmappedSourcePolicy = ReportingPolicy.ERROR
)
public abstract class DtoMapper {
    public abstract Airport mapAirport(ru.nsu.vadim.booking.domain.model.Airport airport);

    @Mapping(target = "copy", ignore = true)
    protected abstract LocalizedString map(ru.nsu.vadim.booking.domain.model.LocalizedString localizedString);

    @Mapping(target = "copy", ignore = true)
    public abstract City mapCity(ru.nsu.vadim.booking.domain.model.City city);

}
