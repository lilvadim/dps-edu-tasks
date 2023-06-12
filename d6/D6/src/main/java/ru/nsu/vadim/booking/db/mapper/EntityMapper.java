package ru.nsu.vadim.booking.db.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.db.entity.AirportEntity;
import ru.nsu.vadim.booking.db.entity.FlightEntity;
import ru.nsu.vadim.booking.domain.model.*;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.TimeZone;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
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

    @Mapping(target = "dayOfWeek", source = "scheduledArrival")
    @Mapping(target = "timeOfArrival", source = "scheduledArrival")
    @Mapping(target = "originAirportCode", source = "departureAirport")
    public abstract InboundScheduleItem mapToInboundScheduleItem(FlightEntity flightEntity);


    @Mapping(target = "timeOfDeparture", source = "scheduledDeparture")
    @Mapping(target = "destinationAirportCode", source = "arrivalAirport")
    @Mapping(target = "dayOfWeek", source = "scheduledDeparture")
    public abstract OutboundScheduleItem mapToOutboundScheduleItem(FlightEntity flightEntity);


    protected DayOfWeek map(ZonedDateTime zonedDateTime) {
        return zonedDateTime.getDayOfWeek();
    }
}
