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
SELECT f.flight_no,
       bp.seat_no,
       CASE
           WHEN tf.amount = MAX(tf.amount) OVER (PARTITION BY f.flight_no, bp.seat_no, tf.fare_conditions)
               AND COUNT(tf.amount) OVER (PARTITION BY f.flight_no, bp.seat_no, tf.fare_conditions) = 2
               THEN CONCAT(tf.fare_conditions, ' Plus')
           ELSE tf.fare_conditions
           END AS fare_conditions,
       tf.amount
FROM ticket_flights tf
         JOIN boarding_passes bp ON tf.ticket_no = bp.ticket_no
         JOIN flights f ON f.flight_id = tf.flight_id
GROUP BY f.flight_no, bp.seat_no, tf.fare_conditions, tf.amount;


