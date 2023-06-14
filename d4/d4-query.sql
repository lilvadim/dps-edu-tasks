-- Information about past bookings
SELECT f.flight_no,
       bp.seat_no,
       tf.fare_conditions,
       COUNT(DISTINCT (tf.amount)) AS count_unique_amounts
FROM ticket_flights tf
         JOIN boarding_passes bp ON tf.ticket_no = bp.ticket_no
         JOIN flights f ON f.flight_id = tf.flight_id
GROUP BY f.flight_no, bp.seat_no, tf.fare_conditions;

-- Pricing rules table
CREATE TABLE prices AS
SELECT f.flight_no,
       bp.seat_no,
       tf.fare_conditions,
       ARRAY_AGG(DISTINCT (tf.amount)) as amounts
FROM ticket_flights tf
         JOIN boarding_passes bp ON tf.ticket_no = bp.ticket_no
         JOIN flights f ON f.flight_id = tf.flight_id
GROUP BY f.flight_no, bp.seat_no, tf.fare_conditions;

create unique index prices_pkey
    on bookings.prices (flight_no, seat_no, fare_conditions);

-- alter table bookings.prices
--     add constraint prices_pkey
--         primary key (flight_no, seat_no, fare_conditions);


