package ru.nsu.vadim.booking.db.entity

import com.vladmihalcea.hibernate.type.array.ListArrayType
import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.io.Serializable

@Entity
@Table(name = "prices")
@IdClass(PriceEntity.Identifier::class)
class PriceEntity {

    data class Identifier(
        var flightNo: String = "",
        var seatNo: String = "",
        var fareConditions: String = "",
    ) : Serializable

    @Id
    lateinit var flightNo: String

    @Id
    lateinit var seatNo: String

    @Id
    lateinit var fareConditions: String

    @Type(ListArrayType::class)
    lateinit var amounts: List<Double>

}