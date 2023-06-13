package ru.nsu.vadim.booking.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.nsu.vadim.booking.db.entity.FlightEntity
import ru.nsu.vadim.booking.db.entity.projection.InboundScheduleItem
import ru.nsu.vadim.booking.db.entity.projection.OutboundScheduleItem

@Repository
interface FlightRepository : JpaRepository<FlightEntity, Long> {

    @Query(
        """
            select 
                flight_no as flightNo,
                cast(array_agg(distinct extract(isodow from scheduled_arrival)) as int[]) as daysOfWeek,
                cast(scheduled_arrival as time) at time zone 'UTC' as timeOfArrival, 
                departure_airport as originAirportCode
            from flights
            where arrival_airport = ?
            group by flightNo, timeOfArrival, originAirportCode
        """,
        nativeQuery = true
    )
    fun findInboundFlights(arrivalAirport: String): List<InboundScheduleItem>

    @Query(
        """
            select 
                flight_no as flightNo,
                cast(array_agg(distinct extract(isodow from scheduled_departure)) as int[]) as daysOfWeek,
                cast(scheduled_departure as time) at time zone 'UTC' as timeOfDeparture, 
                arrival_airport as destinationAirportCode
            from flights
            where departure_airport = ?
            group by flightNo, timeOfDeparture, destinationAirportCode
        """,
        nativeQuery = true
    )
    fun findOutboundFlights(departureAirport: String): List<OutboundScheduleItem>

}