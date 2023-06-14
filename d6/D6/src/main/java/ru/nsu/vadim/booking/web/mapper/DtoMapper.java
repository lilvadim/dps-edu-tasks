package ru.nsu.vadim.booking.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.nsu.vadim.booking.web.dto.*;

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

    public abstract InboundScheduleItem mapItem(ru.nsu.vadim.booking.domain.model.InboundScheduleItem inboundScheduleItem);

    public abstract OutboundScheduleItem mapItem(ru.nsu.vadim.booking.domain.model.OutboundScheduleItem outboundScheduleItem);

    public abstract ru.nsu.vadim.booking.domain.model.BookingRequest map(BookingRequest bookingRequest);

    public abstract Ticket map(ru.nsu.vadim.booking.domain.model.Ticket ticket);

    public abstract BoardingPass map(ru.nsu.vadim.booking.domain.model.BoardingPass boardingPass);

    public abstract ru.nsu.vadim.booking.domain.model.CheckInRequest map(CheckInRequest checkInRequest);
}
