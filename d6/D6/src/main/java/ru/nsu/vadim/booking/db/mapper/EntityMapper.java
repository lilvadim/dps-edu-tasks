package ru.nsu.vadim.booking.db.mapper;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.db.entity.AirportEntity;
import ru.nsu.vadim.booking.domain.model.Airport;
import ru.nsu.vadim.booking.domain.model.City;
import ru.nsu.vadim.booking.domain.model.LocalizedString;

import java.util.TimeZone;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.ERROR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public abstract class EntityMapper {
    @Mapping(target = "timeZone", source = "timezone")
    public abstract Airport mapAirportEntity(AirportEntity airportEntity);

    @Mapping(target = "copy", ignore = true)
    protected abstract LocalizedString map(ru.nsu.vadim.booking.db.entity.type.LocalizedString localizedString);

    @Mapping(target = "copy", ignore = true)
    public abstract City mapCity(ru.nsu.vadim.booking.db.entity.type.City city);

    protected TimeZone map(String value) {
        return TimeZone.getTimeZone(value);
    }
}
