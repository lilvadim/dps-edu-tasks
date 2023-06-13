package ru.nsu.vadim.booking.db.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.db.entity.AirportEntity;
import ru.nsu.vadim.booking.db.entity.projection.CityField;
import ru.nsu.vadim.booking.domain.model.*;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.TimeZone;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public abstract class EntityMapper {
    @Mapping(target = "timeZone", source = "timezone")
    public abstract Airport mapAirportEntity(AirportEntity airportEntity);

    protected LocalizedString mapToLocalizedString(Map<String, String> map) {
        return new LocalizedString(map);
    }

    public City mapToCity(Map<String, String> map) {
        return new City(mapToLocalizedString(map));
    }

    @Mapping(target = "name", source = "city")
    @Mapping(target = "copy", ignore = true)
    public abstract City mapToCity(CityField cityField);

    protected TimeZone map(String value) {
        return TimeZone.getTimeZone(value);
    }

    public abstract OutboundScheduleItem map(ru.nsu.vadim.booking.db.entity.projection.OutboundScheduleItem outboundScheduleItem);

    public abstract InboundScheduleItem map(ru.nsu.vadim.booking.db.entity.projection.InboundScheduleItem inboundScheduleItem);

    protected DayOfWeek mapDay(Number number) {
        return DayOfWeek.of(number.intValue());
    }
}
