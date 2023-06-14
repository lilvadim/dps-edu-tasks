package ru.nsu.vadim.booking.db.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.db.entity.AirportEntity;
import ru.nsu.vadim.booking.db.entity.BoardingPassEntity;
import ru.nsu.vadim.booking.db.entity.TicketEntity;
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
    @Mapping(target = "city.name", source = "city")
    public abstract Airport mapAirportEntity(AirportEntity airportEntity);

    protected LocalizedString mapToLocalizedString(Map<String, String> map) {
        return new LocalizedString(map);
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

    @Mapping(target = "passenger", source = ".")
    @Mapping(target = "bookRef", source = "bookRef.bookRef")
    public abstract Ticket map(TicketEntity ticketEntity);

    @Mapping(target = "name", source = "passengerName")
    @Mapping(target = "id", source = "passengerId")
    protected abstract Passenger mapPassenger(TicketEntity entity);

    protected ContactData mapContactData(Map<String, String> map) {
        if (map == null) {
            return null;
        }

        return new ContactData(
                map.get("phone"),
                map.get("email")
        );
    }

    public abstract BoardingPass map(BoardingPassEntity entity);

    @Mapping(target = "boardingNo", ignore = true)
    public abstract BoardingPassEntity map(CheckInRequest checkInRequest);
}
